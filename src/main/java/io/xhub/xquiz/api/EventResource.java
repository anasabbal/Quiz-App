package io.xhub.xquiz.api;

import io.xhub.xquiz.command.CreateEventSessionCommand;
import io.xhub.xquiz.criteria.EventCriteria;
import io.xhub.xquiz.dto.EventDTO;
import io.xhub.xquiz.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static io.xhub.xquiz.constants.ResourcePath.EVENTS;
import static io.xhub.xquiz.constants.ResourcePath.V1;

@RestController
@RequestMapping(V1 + EVENTS)
@RequiredArgsConstructor
public class EventResource {

    private final EventService eventService;

    @GetMapping
    public ResponseEntity<Page<EventDTO>> getEvents(Pageable pageable, EventCriteria eventCriteria) {
        return ResponseEntity.ok(eventService.getEventsByCriteria(pageable, eventCriteria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEventDetails(
            @PathVariable("id") final String id
    ) {
        return ResponseEntity.ok(eventService.getEvent(id));
    }


    @PostMapping("/sessions")
    public ResponseEntity createSession(
            @RequestBody final CreateEventSessionCommand body
    ) {
        return ResponseEntity.ok(eventService.createSession(body));
    }
}