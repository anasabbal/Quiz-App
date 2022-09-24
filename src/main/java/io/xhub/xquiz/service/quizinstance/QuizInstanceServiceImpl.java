package io.xhub.xquiz.service.quizinstance;


import io.xhub.xquiz.command.CreateEventSessionCommand;
import io.xhub.xquiz.command.QuizInstanceDetailsCommand;
import io.xhub.xquiz.command.UpdateQuizInstanceDetailsCommand;
import io.xhub.xquiz.domain.*;
import io.xhub.xquiz.dto.*;
import io.xhub.xquiz.dto.mapper.QuestionMapper;
import io.xhub.xquiz.dto.mapper.QuizInstanceDetailMapper;
import io.xhub.xquiz.dto.mapper.QuizInstructionMapper;
import io.xhub.xquiz.enums.Status;
import io.xhub.xquiz.enums.SubmitMethod;
import io.xhub.xquiz.exception.BusinessException;
import io.xhub.xquiz.exception.ExceptionPayloadFactory;
import io.xhub.xquiz.repository.*;
import io.xhub.xquiz.service.answer.AnswerService;
import io.xhub.xquiz.service.attendee.AttendeeService;
import io.xhub.xquiz.service.attendeeevent.AttendeeEventService;
import io.xhub.xquiz.service.event.EventService;
import io.xhub.xquiz.service.eventsetup.EventSetupService;
import io.xhub.xquiz.service.question.QuestionService;
import io.xhub.xquiz.service.quizInstanceDetails.QuizInstanceDetailsService;
import io.xhub.xquiz.service.quizinstruction.QuizInstructionsService;
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
import java.util.stream.Collectors;

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
    private final QuizInstructionsService quizInstructionsService;
    private final QuizInstructionMapper quizInstructionMapper;
    private final QuestionService questionService;
    private final QuizInstanceDetailsService quizInstanceDetailsService;
    private final QuizInstanceDetailMapper quizInstanceDetailMapper;
    private final QuestionMapper questionMapper;
    private final QuestionAnswerDetailsRepository questionAnswerDetailsRepository;
    private final AnswerService answerService;
    private final RestTemplate restTemplate;

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
            log.info("Status of Quiz instance with id {} updated successfully to {}", quizInstanceId, quizInstance.getStatus());
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

                HttpHeaders headers = new HttpHeaders();
                HttpEntity<?> entity = new HttpEntity<>(headers);
                final HttpMethod method = getHttpSubmitMethod(eventSetup.getSubmitMethod());
                final ResponseEntity<ResponseAttendeeDTO> response = restTemplate.exchange(eventSetup.getSubmitUrl(),
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
        } else if (Status.CLOSED.equals(quizInstance.get().getCurrentStatus())) {
            throw new BusinessException(ExceptionPayloadFactory.QUIZ_INSTANCE_CLOSED.get());
        } else if (Status.FINISHED.equals(quizInstance.get().getCurrentStatus())) {
            throw new BusinessException(ExceptionPayloadFactory.QUIZ_INSTANCE_FINISHED.get());
        }
        return quizInstance.get();
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
        return quizInstructionMapper.dtoList(quizInstructionsService.findAllQuizInstruction());
    }

    @Override
    public QuizInstruction getQuizInstructionsByKey(final String key) {
        log.info("Begin fetching quiz instruction with time limit");
        final QuizInstruction quizInstruction = quizInstructionsService.findQuizInstructionByKey(key);
        log.info("Quiz instruction fetched successfully");
        return quizInstruction;
    }

    @Override
    public QuizDetailDTO startQuiz(QuizInstanceDetailsCommand quizInstanceDetailsCommand) {
        final QuizInstance quizInstance = findById(quizInstanceDetailsCommand.getSessionId());
        log.info("Session with id {} fetched successfully", quizInstance.getId());

        final Integer totalQuestions = Integer.valueOf(getQuizInstructionsByKey("TOTAL_QUESTIONS").getValue());

        final QuizInstruction quizInstruction = getQuizInstructionsByKey("TIME_LIMIT");

        final LocalDateTime startDate = LocalDateTime.now();

        quizInstance.setStartDate(LocalDateTime.now());

        quizInstance.setEndDate(LocalDateTime.now().plusSeconds(Long.parseLong(quizInstruction.getValue())));

        if (Boolean.FALSE.equals(quizInstanceDetailsService.checkIfSessionQuestionsExist(quizInstance.getId()))) {

            log.info("Begin fetching questions with seniority level id {} and sub theme id {}", quizInstanceDetailsCommand.getSeniorityLevelId(),
                    quizInstanceDetailsCommand.getThemeId());
            final List<Question> questions = questionService.findQuestionsByPercentage(
                    quizInstanceDetailsCommand, totalQuestions);
            log.info("Questions with size {} fetched successfully", questions.size());

            if (questions.isEmpty())
                throw new BusinessException(ExceptionPayloadFactory.QUESTIONS_NOT_FOUND.get());
            log.info("Begin creating question");
            questions.forEach(question -> quizInstanceDetailsService.save(QuizInstanceDetails.create(question, quizInstance, questions.indexOf(question) + 1)));

            QuestionDTO questionDTO = questionMapper.toQuestionDTO(questions.get(0));

            questionDTO.setTotalCorrectAnswers(getTotalCorrectAnswers(questions.get(0).getId()));

            quizInstance.setStatus(Status.PENDING);
            return QuizDetailDTO.create(questionDTO, Integer.valueOf(quizInstruction.getValue()), startDate, quizInstance.getEndDate());
        } else {
            QuizInstanceDetailsDTO quizInstanceDetailsDTO = quizInstanceDetailMapper.toQuizInstanceDetailsDTO(quizInstanceDetailsService.
                    findQuizInstanceDetailsByQuizInstanceAndQuestionIndex(quizInstance.getId(), quizInstance.getLastQuestionIndex()));
            quizInstanceDetailsDTO.getQuestion().setTotalCorrectAnswers(getTotalCorrectAnswers(quizInstanceDetailsDTO.getQuestion().getId()));
            log.info("Status set to PENDING");
            quizInstance.setStatus(Status.PENDING);
            return QuizDetailDTO.create(quizInstanceDetailsDTO.getQuestion(), Integer.valueOf(quizInstruction.getValue()), startDate, quizInstance.getEndDate());
        }
    }

    private Integer getTotalCorrectAnswers(final String id) {
        return answerService.countCorrectAnswers(id);
    }

    @Override
    public Attendee getAttendeeByQuizInstanceId(final String id) {
        return quizInstanceRepository.findAttendeeByQuizInstance(id).orElseThrow(
                () -> new BusinessException(ExceptionPayloadFactory.ATTENDEE_NOT_FOUND.get())
        );
    }

    @Override
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

    @Override
    public QuestionDTO answer(String quizInstanceId, UpdateQuizInstanceDetailsCommand command) {
        final QuizInstance quizInstance = findById(quizInstanceId);
        log.info("Session with id {} fetched successfully", quizInstanceId);

        final List<Answer> answers = answerService.getAnswersByIds(command.getAnswersId().stream().distinct().collect(Collectors.toList()));
        log.info("Answers with size {} fetched successfully", answers.size());

        final Question question = answerService.getQuestion(command, answers);

        final QuizInstanceDetails quizInstanceDetails = quizInstanceDetailsService
                .getQuizInstanceDetails(quizInstanceId, question.getId());
        log.info("Quiz instance details with id {} fetched successfully", quizInstanceDetails.getId());

        if (Boolean.TRUE.equals(answerService.answerVerification(answers, question)))
            quizInstanceDetails.setScore(question.getScore());

        updateLastQuestionIndexAndFinalScore(quizInstanceDetails, quizInstance);

        quizInstanceDetailsService.save(quizInstanceDetails);
        log.info("quizInstanceDetails updated successfully");
        answerService.createQuestionAnswerDetails(answers, quizInstanceDetails);

        log.info("Begin fetching total question");
        final Integer totalQuestions = Integer.valueOf(getQuizInstructionsByKey("TOTAL_QUESTIONS").getValue());

        if (quizInstanceDetails.getQuestionIndex().equals(totalQuestions)) {
            return null;
        }

        log.info("Begin fetching next quiz instance details with id {} and last question {}", quizInstanceId, quizInstance.getLastQuestionIndex() + 1);
        QuizInstanceDetails nextQuizInstanceDetails = quizInstanceDetailsService.getQuizInstanceDetailsByQuestionIndex(quizInstanceId, quizInstance.getLastQuestionIndex() + 1);
        QuestionDTO nextQuestion = quizInstanceDetailMapper.toQuizInstanceDetailsDTO(nextQuizInstanceDetails).getQuestion();
        nextQuestion.setTotalCorrectAnswers(answerService.countCorrectAnswers(nextQuestion.getId()));
        return nextQuestion;
    }

    @Override
    public PassMarkDTO finishQuiz(String quizInstanceId) {
        QuizInstance quizInstance = findById(quizInstanceId);
        log.info("Quiz instance with the id {} was set to finished", quizInstanceId);
        quizInstance.setStatus(Status.FINISHED);
        quizInstance.setEndDate(LocalDateTime.now());
        log.info("Begin sum question score by quiz instance id {}", quizInstanceId);
        final Integer perfectScore = quizInstanceDetailsService.sumQuestionScore(quizInstanceId);
        final Integer scorePercentage = findById(quizInstanceId).getFinalScore();
        log.info("Begin fetching pass  mark from quiz instruction");
        final Integer passMark = Integer.valueOf(getQuizInstructionsByKey("PASS_TASK").getValue());
        float attendeeMark = (Float.valueOf(scorePercentage) * 100 / Float.valueOf(perfectScore));
        quizInstance.updatePercentFinalScore(attendeeMark);
        quizInstanceRepository.save(quizInstance);
        return PassMarkDTO.create(passMark, attendeeMark);
    }

}
