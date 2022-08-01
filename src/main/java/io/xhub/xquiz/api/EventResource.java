package io.xhub.xquiz.api;

import io.xhub.xquiz.dto.EventDTO;
import io.xhub.xquiz.dto.mapper.EventMapper;
import io.xhub.xquiz.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static io.xhub.xquiz.constants.ResourcePath.EVENTS;
import static io.xhub.xquiz.constants.ResourcePath.V1;

@RestController
@RequestMapping(V1 + EVENTS)
@RequiredArgsConstructor
public class EventResource {

    private final EventMapper eventMapper;
    private final EventService eventService;

    @GetMapping
    public ResponseEntity<List<EventDTO>> getEvents() {
        return ResponseEntity.ok(eventMapper.toEventDTO(eventService.getAllActiveEvents()));
    }
}
