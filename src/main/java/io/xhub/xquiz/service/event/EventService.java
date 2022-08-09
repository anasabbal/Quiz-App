package io.xhub.xquiz.service.event;

import io.xhub.xquiz.command.CreateEventSessionCommand;
import io.xhub.xquiz.criteria.EventCriteria;
import io.xhub.xquiz.dto.EventDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventService {

    EventDTO getEvent(final String id);

    Page<EventDTO> getEventsByCriteria(Pageable pageable, EventCriteria eventCriteria);

    Object createSession(final CreateEventSessionCommand body);
}
