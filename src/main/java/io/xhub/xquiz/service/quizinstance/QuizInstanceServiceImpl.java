package io.xhub.xquiz.service.quizinstance;


import io.xhub.xquiz.command.CreateEventSessionCommand;
import io.xhub.xquiz.command.QuizInstanceDetailsCommand;
import io.xhub.xquiz.domain.*;
import io.xhub.xquiz.dto.QuizDetailDTO;
import io.xhub.xquiz.dto.QuizInstanceDetailsDTO;
import io.xhub.xquiz.dto.QuizInstructionDTO;
import io.xhub.xquiz.dto.ResponseAttendeeDTO;
import io.xhub.xquiz.dto.mapper.QuestionMapper;
import io.xhub.xquiz.dto.mapper.QuizInstanceDetailMapper;
import io.xhub.xquiz.dto.mapper.QuizInstructionMapper;
import io.xhub.xquiz.enums.Status;
import io.xhub.xquiz.enums.SubmitMethod;
import io.xhub.xquiz.exception.BusinessException;
import io.xhub.xquiz.exception.ExceptionPayloadFactory;
import io.xhub.xquiz.repository.*;
import io.xhub.xquiz.service.attendee.AttendeeService;
import io.xhub.xquiz.service.attendeeevent.AttendeeEventService;
import io.xhub.xquiz.service.event.EventService;
import io.xhub.xquiz.service.eventsetup.EventSetupService;
import io.xhub.xquiz.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class QuizInstanceServiceImpl implements QuizInstanceService {

    private final EventService eventService;
    private final EventSetupService eventSetupService;
    private final AttendeeService attendeeService;
    private final AttendeeEventService attendeeEventService;
    private final QuizInstanceRepository quizInstanceRepository;
    private final QuizInstructionRepository quizInstructionRepository;
    private final QuizInstructionMapper quizInstructionMapper;
    private final QuestionRepository questionRepository;
    private final QuizInstanceDetailRepository quizInstanceDetailRepository;
    private final QuizInstanceDetailMapper quizInstanceDetailMapper;
    private final QuestionMapper questionMapper;
    private final QuestionAnswerDetailsRepository questionAnswerDetailsRepository;

    @Override
    public QuizInstance findById(String quizInstanceId) {
        log.info("Begin fetching quiz instance with id {}", quizInstanceId);
        return quizInstanceRepository.findById(quizInstanceId)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.QUIZ_INSTANCE_NOT_FOUND.get()));
    }

    @Override
    public void updateStatus(String quizInstanceId) {
        final QuizInstance quizInstance = findById(quizInstanceId);

        Status status = quizInstance.getCurrentStatus();

        if (Status.PENDING.equals(status)) {
            quizInstance.updateStatusToClosed();
            quizInstanceRepository.save(quizInstance);
            log.info("Status of Quiz instance with id {} updated successfully and payload is {}", quizInstanceId, JSONUtil.toJSON(quizInstance));
        }

    }

    @Override
    public QuizInstance createSession(final CreateEventSessionCommand body) {

        final Event event = eventService.getEvent(body.getEventId());
        final EventSetup eventSetup = eventSetupService.getEventSetup(body.getEventSetupId());

        Attendee attendee = null;

        try {
            if (Objects.isNull(eventSetup.getSubmitUrl())) {
                attendee = attendeeService.getOrCreateAttendee(body);
            } else {

                log.info("Start fetching attendee with the registration code : {}", JSONUtil.toJSON(body.getPayload().get("registrationCode")));

                final RestTemplate template = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                HttpEntity<?> entity = new HttpEntity<>(headers);
                final HttpMethod method = getHttpSubmitMethod(eventSetup.getSubmitMethod());
                final ResponseEntity<ResponseAttendeeDTO> response = template.exchange(eventSetup.getSubmitUrl(),
                        method, entity, ResponseAttendeeDTO.class, body.getPayload());

                ensureResponseIsOk(response);
                ResponseAttendeeDTO userResponse = response.getBody();
                log.info("attendee with the payload {} retrieved successfully", JSONUtil.toJSON(userResponse));
                attendee = attendeeService.getOrCreateAttendee(userResponse);
            }
            if (Objects.isNull(attendee))
                throw new BusinessException(ExceptionPayloadFactory.TECHNICAL_ERROR.get());

        } catch (RestClientException e) {
            throw new BusinessException(ExceptionPayloadFactory.REGISTRATION_CODE_NOT_FOUND.get());
        }
        AttendeeEvent attendeeEvent = attendeeEventService.getOrCreateAttendeeEvent(attendee, event);

        QuizInstance quizInstance = getOrCreate(attendeeEvent);
        log.info("Quiz Session opened successfully with ID {}", quizInstance.getId());
        return quizInstance;
    }

    private QuizInstance getOrCreate(AttendeeEvent attendeeEvent) {
        Optional<QuizInstance> quizInstance = quizInstanceRepository.findByAttendeeEvent(attendeeEvent);
        if (quizInstance.isEmpty()) {
            return quizInstanceRepository.save(QuizInstance.create(attendeeEvent));
        } else if (!Status.CLOSED.equals(quizInstance.get().getCurrentStatus())) {
            return quizInstance.get();
        }
        throw new BusinessException(ExceptionPayloadFactory.QUIZ_INSTANCE_CLOSED.get());
    }

    private void ensureResponseIsOk(final ResponseEntity<ResponseAttendeeDTO> response) {
        if (!HttpStatus.OK.equals(response.getStatusCode()))
            throw new BusinessException(ExceptionPayloadFactory.ATTENDEE_RESPONSE_NOT_OK.get());
    }

    private HttpMethod getHttpSubmitMethod(final SubmitMethod submitMethod) {
        if (SubmitMethod.GET.equals(submitMethod)) {
            return HttpMethod.GET;
        }
        if (SubmitMethod.POST.equals(submitMethod)) {
            return HttpMethod.POST;
        }
        throw new BusinessException(ExceptionPayloadFactory.HTTP_SUBMIT_METHOD_NOT_SUPPORTED.get());
    }

    public List<QuizInstructionDTO> getQuizInstructions() {
        return quizInstructionMapper.dtoList(quizInstructionRepository.findAllQuizInstructionByDeletedFalse());
    }

    @Override
    public QuizDetailDTO startQuiz(QuizInstanceDetailsCommand quizInstanceDetailsCommand) {

        final QuizInstance quizInstance = findById(quizInstanceDetailsCommand.getSessionId());

        final Integer totalQuestions = Integer.valueOf(quizInstructionRepository.findQuizInstructionByKey("TOTAL_QUESTIONS").getValue());

        final QuizInstruction quizInstruction = quizInstructionRepository.findQuizInstructionByKey("TIME_LIMIT");

        final LocalDateTime startDate = LocalDateTime.now();


        quizInstance.setStartDate(LocalDateTime.now());

        if (Boolean.FALSE.equals(checkIfSessionQuestionsExist(quizInstance.getId()))) {

            final List<Question> questions = questionRepository.findListQuestionBySeniorityLevelIdAndSubThemeId(
                    quizInstanceDetailsCommand.getSeniorityLevelId(),
                    quizInstanceDetailsCommand.getSubThemeId(), totalQuestions);

            questions.forEach(question -> quizInstanceDetailRepository.save(QuizInstanceDetails.create(question, quizInstance, questions.indexOf(question) + 1)));
            return QuizDetailDTO.create(questionMapper.toQuestionDTO(questions.get(0)), Integer.valueOf(quizInstruction.getValue()), startDate);
        } else {
            QuizInstanceDetailsDTO quizInstanceDetailsDTO = quizInstanceDetailMapper.toQuizInstanceDetailsDTO(quizInstanceDetailRepository.
                    findQuizInstanceDetailsByQuizInstanceIdAndQuestionIndex(quizInstance.getId(), quizInstance.getLastQuestionIndex()));
            return QuizDetailDTO.create(quizInstanceDetailsDTO.getQuestion(), Integer.valueOf(quizInstruction.getValue()), startDate);
        }
    }

    @Override
    public Attendee getAttendeeByQuizInstanceId(final String id) {
        return quizInstanceRepository.findAttendeeByQuizInstance(id).orElseThrow(
                () -> new BusinessException(ExceptionPayloadFactory.ATTENDEE_NOT_FOUND.get())
        );
    }

    private Boolean checkIfSessionQuestionsExist(final String sessionId) {
        return quizInstanceDetailRepository.existsByQuizInstanceId(sessionId);
    }

    public void updateLastQuestionIndexAndFinalScore(QuizInstanceDetails quizInstanceDetails, QuizInstance quizInstance) {
        if (questionAnswerDetailsRepository.existsQuestionAnswerDetailsById_QuestionDetails(quizInstanceDetails.getId())) {
            throw new BusinessException(ExceptionPayloadFactory.QUESTION_ALREADY_ANSWERED.get());
        }
        quizInstance.setLastQuestionIndex(quizInstance.getLastQuestionIndex() + 1);
        quizInstance.setFinalScore(quizInstanceDetails.getScore() + quizInstance.getFinalScore());
        quizInstanceRepository.save(quizInstance);
        log.info("Last question index and final score updated  successfully with index value {} and score value {}"
                , quizInstance.getLastQuestionIndex(), quizInstance.getFinalScore());
    }


}
