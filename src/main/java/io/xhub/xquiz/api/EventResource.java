package io.xhub.xquiz.api;

import io.xhub.xquiz.command.CreateEventSessionCommand;
import io.xhub.xquiz.dto.EventDTO;
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

    private final EventService eventService;

    @GetMapping // add pagination & criteria
    public ResponseEntity<List<EventDTO>> getEvents() {
        // todo:add pagination and sort + criteria for search
        return ResponseEntity.ok(eventService.getAllActiveEvents());
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
