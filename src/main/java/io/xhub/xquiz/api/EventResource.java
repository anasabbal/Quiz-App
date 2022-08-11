package io.xhub.xquiz.api;

import io.xhub.xquiz.criteria.EventCriteria;
import io.xhub.xquiz.domain.Event;
import io.xhub.xquiz.dto.EventDTO;
import io.xhub.xquiz.dto.mapper.EventMapper;
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
    private final EventMapper eventMapper;

    @GetMapping
    public ResponseEntity<Page<EventDTO>> getEvents(Pageable pageable, EventCriteria eventCriteria) {
        Page<Event> events = eventService.getEventsByCriteria(pageable, eventCriteria);
        return ResponseEntity.ok(events.map(eventMapper::toEventDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEventDetails(@PathVariable final String id) {

        return ResponseEntity.ok(eventMapper.toEventDTO(eventService.getEvent(id)));
    }

}
