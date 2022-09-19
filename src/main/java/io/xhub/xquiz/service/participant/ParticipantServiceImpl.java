package io.xhub.xquiz.service.participant;

import io.xhub.xquiz.command.ParticipantGoodyCommand;
import io.xhub.xquiz.domain.Event;
import io.xhub.xquiz.domain.Goody;
import io.xhub.xquiz.dto.ParticipantDetailsDTO;
import io.xhub.xquiz.exception.BusinessException;
import io.xhub.xquiz.exception.ExceptionPayloadFactory;
import io.xhub.xquiz.repository.AttendeeEventRepository;
import io.xhub.xquiz.repository.AttendeeRepository;
import io.xhub.xquiz.repository.EventRepository;
import io.xhub.xquiz.repository.GoodyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ParticipantServiceImpl implements ParticipantService {

    private final GoodyRepository goodyRepository;
    private final AttendeeEventRepository attendeeEventRepository;
    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;

    /**
     * @param keyword only matches the firstName and lastName of the participant - default is _
     * @return a page of DTO projections of Participants Details
     */
    @Override
    public Page<ParticipantDetailsDTO> getAllByCriteria(final String keyword, final Pageable pageable) {
        log.info("Start fetching participants details that match keyword '{}'", keyword);
        return attendeeRepository.findAllParticipantDetailsByCriteria(keyword, pageable);
    }

    @Override
    public int countEventParticipants() {
        Optional<Event> currentEventOpt = eventRepository.findLast();
        if(currentEventOpt.isEmpty())
            return 0;

        return attendeeEventRepository.countEventParticipants(currentEventOpt.get());
    }


    @Override
    public List<Goody> getAllGoodies() {
        log.info("Start fetching all available goodies");
        return goodyRepository.findAllByDeletedFalse();
    }

    @Override
    public void giftGoody(final String participantID, final ParticipantGoodyCommand command) {
        command.validate();
        final Optional<Event> currentEvent = eventRepository.findLast();
        if (currentEvent.isEmpty())
            throw new BusinessException(ExceptionPayloadFactory.EVENT_NOT_FOUND.get());

        attendeeEventRepository
                .findEventParticipantByID(currentEvent.get(), participantID)
                .ifPresentOrElse(eventParticipant -> {
                    final Goody goody = getById(command.getGoodyID());
                    if (goody.isOutOfStock())
                        throw new BusinessException(ExceptionPayloadFactory.GOODIES_OUT_OF_STOCK.get(), goody.getId());

                    final boolean isEligibleForGoody = eventParticipant
                            .isEligibleForGoody(goody,
                                    attendeeEventRepository.getEventParticipantTechnicalQuizScore(
                                            eventParticipant.getId().getEvent(),
                                            eventParticipant.getId().getAttendee()), 0);
                    if (!isEligibleForGoody)
                        throw new BusinessException(ExceptionPayloadFactory.PARTICIPANT_IS_NOT_ELIGIBLE_FOR_GOODY.get(), eventParticipant.getId().getAttendee().getId(), goody.getLabel());

                    eventParticipant.giftGoody(goody);
                    attendeeEventRepository.save(eventParticipant);
                    log.info("Participant with id '{}' has successfully received the goody with id '{}'", eventParticipant.getId().getAttendee().getId(), goody.getId());
                }, () ->
                {
                    throw new BusinessException(ExceptionPayloadFactory.QUIZ_EVENT_PARTICIPANT_NOT_FOUND.get(), participantID, currentEvent.get().getName());
                });
    }

    @Override
    public Goody getById(final String id) {
        log.info("Start fetching goody with id '{}'", id);
        Goody goody = goodyRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.GOODY_NOT_FOUND.get(), id));
        log.info("Goody with id '{}' fetched successfully", id);

        return goody;
    }
}