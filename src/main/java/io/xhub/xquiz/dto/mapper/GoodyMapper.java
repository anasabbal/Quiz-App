package io.xhub.xquiz.dto.mapper;

import io.xhub.xquiz.domain.AttendeeEvent;
import io.xhub.xquiz.domain.Event;
import io.xhub.xquiz.domain.Goody;
import io.xhub.xquiz.dto.GoodyDTO;
import io.xhub.xquiz.repository.AttendeeEventRepository;
import io.xhub.xquiz.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GoodyMapper {

    private final AttendeeEventRepository attendeeEventRepository;
    private final EventRepository eventRepository;

    public GoodyDTO toParticipantEligibleGoodyDTO(Goody goody, String participantID) {
        if (goody == null || participantID == null) return null;

        Optional<Event> eventOpt = eventRepository.findLast();
        if(eventOpt.isEmpty()) return null;
        Optional<AttendeeEvent> eventParticipantOpt =
                attendeeEventRepository.findEventParticipantByID(eventOpt.get(), participantID);
        if (eventParticipantOpt.isEmpty()) return null;

        final AttendeeEvent eventParticipant = eventParticipantOpt.get();
        final GoodyDTO goodyDTO = new GoodyDTO();
        goodyDTO.setId(goody.getId());
        goodyDTO.setLabel(goody.getLabel());
        goodyDTO.setStock(goody.getAvailableStock());
        goodyDTO.setEligible(
                eventParticipant.isEligibleForGoody(goody,
                                attendeeEventRepository
                                        .getEventParticipantTechnicalQuizScore(
                                                eventParticipant.getId().getEvent(),
                                                eventParticipant.getId().getAttendee()), 0));

        return goodyDTO;
    }

    public List<GoodyDTO> toParticipantEligibleGoodiesDTOList(List<Goody> goodies, String participantID) {
        if (goodies == null || goodies.isEmpty() || participantID == null) return new ArrayList<>();

        return goodies.stream()
                .map(goody -> toParticipantEligibleGoodyDTO(goody, participantID))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
