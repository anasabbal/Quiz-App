package io.xhub.xquiz.service.event;

import io.xhub.xquiz.domain.Event;

import java.util.List;

public interface EventService {

    List<Event> getAllActiveEvents();
}
