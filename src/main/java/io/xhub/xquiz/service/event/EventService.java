package io.xhub.xquiz.service.event;

import io.xhub.xquiz.command.CreateEventSessionCommand;
import io.xhub.xquiz.domain.Event;
import io.xhub.xquiz.dto.EventDTO;

import java.util.List;

public interface EventService {

    List<EventDTO> getAllActiveEvents();
    EventDTO getEvent(final String id);

    Object createSession(final CreateEventSessionCommand body);
}
