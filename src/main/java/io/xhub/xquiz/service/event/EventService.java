package io.xhub.xquiz.service.event;

import io.xhub.xquiz.domain.Event;
import io.xhub.xquiz.dto.EventDTO;

import java.util.List;

public interface EventService {

    List<EventDTO> getAllActiveEvents();
}
