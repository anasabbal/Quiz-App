package io.xhub.xquiz.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.xhub.xquiz.command.FeedBackCommand;
import io.xhub.xquiz.command.ParticipantGoodyCommand;
import io.xhub.xquiz.constants.ResourcePath;
import io.xhub.xquiz.criteria.EventCriteria;
import io.xhub.xquiz.domain.Event;
import io.xhub.xquiz.domain.projection.ParticipantCulturalQuizAnswerDTO;
import io.xhub.xquiz.domain.projection.ParticipantDetailDTO;
import io.xhub.xquiz.domain.projection.ParticipantGoodiesDTO;
import io.xhub.xquiz.dto.*;
import io.xhub.xquiz.dto.EventDTO;
import io.xhub.xquiz.dto.EventDetailsDTO;
import io.xhub.xquiz.dto.FeedbackDTO;
import io.xhub.xquiz.dto.ParticipantCulturalQuizRecapDTO;
import io.xhub.xquiz.dto.*;
import io.xhub.xquiz.dto.mapper.EventMapper;
import io.xhub.xquiz.dto.mapper.FeedbackMapper;
import io.xhub.xquiz.dto.mapper.TechQuizRecapMapper;
import io.xhub.xquiz.service.event.EventService;
import io.xhub.xquiz.service.participant.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static io.xhub.xquiz.constants.ResourcePath.*;

@RestController
@Api(tags = "Event Participants Management Resource")
@RequestMapping(V1 + EVENTS)
@RequiredArgsConstructor
public class EventResource {

    private final EventService eventService;
    private final ParticipantService participantService;
    private final EventMapper eventMapper;
    private final FeedbackMapper feedbackMapper;
    private final TechQuizRecapMapper techQuizRecapMapper;

    @GetMapping
    public ResponseEntity<Page<EventDTO>> getEvents(Pageable pageable, EventCriteria eventCriteria) {
        Page<Event> events = eventService.getEventsByCriteria(pageable, eventCriteria);
        return ResponseEntity.ok(events.map(eventMapper::toEventDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDetailsDTO> getEventDetails(@PathVariable final String id) {
        return ResponseEntity.ok(eventMapper.toEventDetailsDTO(eventService.getEvent(id)));
    }

    @GetMapping(PARTICIPANTS)
    @ApiOperation(value = "Page of event participants details that have finished a session in xQuiz")
    public ResponseEntity<Page<ParticipantDetailDTO>> getAllParticipants(
            @RequestParam(value = "keyword", required = false, defaultValue = "_") final String keyword,
            final Pageable pageable) {
        return ResponseEntity.ok(participantService.getAllEventParticipantsByCriteria(keyword, pageable));
    }


    @GetMapping("/{eventID}" + PARTICIPANTS + "/{participantID}" + GOODIES)
    @ApiOperation(value = "List of all the participant's eligible goodies")
    public ResponseEntity<List<ParticipantGoodiesDTO>> getAllGoodies(@PathVariable final String participantID, @PathVariable String eventID) {
        return ResponseEntity.ok(participantService.getGoodies(eventID, participantID));
    }

    @PatchMapping("/{eventID}" + PARTICIPANTS + "/{participantID}" + GOODIES)
    @ApiOperation(value = "Gift a Goody to a participant that has finished the xQuiz")
    public ResponseEntity<Void> giftGoody(@PathVariable final String eventID,
                                          @PathVariable final String participantID,
                                          @RequestBody final ParticipantGoodyCommand command) {
        participantService.giftGoody(eventID, participantID, command);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{eventID}" + PARTICIPANTS + "/{participantID}" + FEEDBACK)
    @ApiOperation(value = "Submit xInterviewer's feedback on the xQuiz Participant session")
    public ResponseEntity<Void> feedBack(@PathVariable final String eventID,
                                         @PathVariable final String participantID,
                                         @RequestBody final FeedBackCommand feedBackCommand) {
        participantService.submitFeedback(eventID, participantID, feedBackCommand);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{eventID}" + PARTICIPANTS + "/{participantID}" + FEEDBACK)
    @ApiOperation(value = "Get xInterviewer's feedback on the xQuiz Participant session")
    public ResponseEntity<FeedbackDTO> getFeedBack(@PathVariable final String eventID,
                                                   @PathVariable final String participantID) {
        return ResponseEntity.ok().body(feedbackMapper.toFeedbackDTO(participantService.getFeedback(eventID, participantID)));
    }

    @GetMapping("/{eventID}" + PARTICIPANTS + "/{participantID}" + CULTURAL_QUIZ_RECAP)
    @ApiOperation(value = "Get cultural quiz recap on the xQuiz Participant session")
    public ResponseEntity<ParticipantCulturalQuizRecapDTO> getCulturalQuizRecap(@PathVariable final String eventID,
                                                                                @PathVariable final String participantID) {
        return ResponseEntity.ok().body(participantService.getCulturalQuizRecap(participantID, eventID));
    }


    @GetMapping("/{eventID}" + PARTICIPANTS + "/{participantID}" + ResourcePath.TECH_QUIZ_RECAP)
    @ApiOperation(value = "Get xQuiz participant technical quiz recap")
    public ResponseEntity<TechQuizRecapDTO> getTechQuizRecap(@PathVariable final String eventID,
                                                             @PathVariable final String participantID) {
        return ResponseEntity.ok().body(
                techQuizRecapMapper.toTechQuizRecapDTO(
                        participantService.getTechnicalQuizRecap(eventID, participantID),
                        participantService.getEventParticipantTechnicalQuizPercentScore(eventID, participantID),
                        participantService.getTimePassed(eventID, participantID)
                ));
    }
}
