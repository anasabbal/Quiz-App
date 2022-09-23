package io.xhub.xquiz.service.participant;

import io.xhub.xquiz.command.FeedBackCommand;
import io.xhub.xquiz.command.ParticipantGoodyCommand;
import io.xhub.xquiz.domain.AttendeeEvent;
import io.xhub.xquiz.domain.Feedback;
import io.xhub.xquiz.domain.Goody;
import io.xhub.xquiz.domain.projection.ParticipantDetailDTO;
import io.xhub.xquiz.domain.projection.ParticipantGoodiesDTO;
import io.xhub.xquiz.exception.BusinessException;
import io.xhub.xquiz.exception.ExceptionPayloadFactory;
import io.xhub.xquiz.repository.AttendeeEventRepository;
import io.xhub.xquiz.repository.AttendeeRepository;
import io.xhub.xquiz.repository.GoodyRepository;
import io.xhub.xquiz.service.config.BusinessConfigService;
import io.xhub.xquiz.service.config.ConfigKeys;
import io.xhub.xquiz.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ParticipantServiceImpl implements ParticipantService {

    private final BusinessConfigService businessConfigService;
    private final AttendeeEventRepository attendeeEventRepository;
    private final AttendeeRepository attendeeRepository;
    private final GoodyRepository goodyRepository;


    /**
     * @param keyword only matches the firstName and lastName of the participant - default is _
     * @return a page of DTO projections of Participants Details
     */
    @Override
    public Page<ParticipantDetailDTO> getAllEventParticipantsByCriteria(final String keyword, final Pageable pageable) {
        log.info("Start fetching all participants details");
        return attendeeRepository.findAllParticipantDetailsByCriteria(keyword, pageable);
    }

    @Override
    public void submitFeedback(final String eventID, final String participantID, final FeedBackCommand command) {
        command.validate();
        final AttendeeEvent eventParticipant = getEventParticipant(eventID, participantID);
        eventParticipant.submitInterviewFeedback(command.getContent());
        attendeeEventRepository.save(eventParticipant);
        log.info("Feedback {} submitted successfully for participant with id '{}'", JSONUtil.toJSON(command), participantID);
    }


    @Override
    public List<ParticipantGoodiesDTO> getGoodies(final String eventID, final String participantID) {
        log.info("Start fetching all available goodies for event with id '{}' and participant with id '{}'", eventID, participantID);
        return goodyRepository
                .findAllEventParticipantGoodies(eventID, participantID,
                        businessConfigService.getFloatValue(ConfigKeys.TECH_QUIZ_FACTOR),
                        businessConfigService.getFloatValue(ConfigKeys.CULT_QUIZ_FACTOR));
    }

    @Override
    public void giftGoody(final String eventID, final String participantID, final ParticipantGoodyCommand command) {
        command.validate();

        final AttendeeEvent eventParticipant = getEventParticipant(eventID, participantID);
        final Goody goody = getGoody(command.getGoodyID());
        if (goody.isOutOfStock())
            throw new BusinessException(ExceptionPayloadFactory.GOODIES_OUT_OF_STOCK.get(), goody.getId());

        final boolean isEligibleForGoody = eventParticipant
                .isEligibleForGoody(goody,
                        () -> attendeeEventRepository.getEventParticipantTechnicalQuizPercentScore(eventID, participantID),
                        () -> attendeeEventRepository.getEventParticipantCulturalQuizPercentScore(eventID, participantID),
                        businessConfigService.getFloatValue(ConfigKeys.TECH_QUIZ_FACTOR),
                        businessConfigService.getFloatValue(ConfigKeys.CULT_QUIZ_FACTOR)
                );

        if (!isEligibleForGoody)
            throw new BusinessException(ExceptionPayloadFactory.PARTICIPANT_IS_NOT_ELIGIBLE_FOR_GOODY.get(), eventParticipant.getId().getAttendee().getId(), goody.getLabel());

        eventParticipant.giftGoody(goody);
        attendeeEventRepository.save(eventParticipant);
        log.info("Participant with id '{}' has successfully received the goody with id '{}'", eventParticipant.getId().getAttendee().getId(), goody.getId());
    }

    @Override
    public Goody getGoody(final String goodyID) {
        log.info("Start fetching goody with goodyID '{}'", goodyID);
        final Goody goody = goodyRepository.findByIdAndDeletedFalse(goodyID)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.GOODY_NOT_FOUND.get(), goodyID));
        log.info("Goody with goodyID '{}' fetched successfully", goodyID);

        return goody;
    }

    @Override
    public AttendeeEvent getEventParticipant(final String eventID, final String participantID) {
        log.info("Begin fetching participant with id '{}' in event with id '{}'", participantID, eventID);
        return attendeeEventRepository.findEventParticipantByID(eventID, participantID)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.QUIZ_EVENT_PARTICIPANT_NOT_FOUND.get(), participantID));
    }

    @Override
    public Feedback getFeedback(String eventID, String participantID) {
        log.info("Begin fetching xInterviewer feedback on participant with id '{}' and event with id '{}'", participantID, eventID);
        return getEventParticipant(eventID, participantID).getFeedBack();
    }
}