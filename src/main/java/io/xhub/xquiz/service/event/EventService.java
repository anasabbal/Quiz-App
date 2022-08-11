package io.xhub.xquiz.service.event;

import io.xhub.xquiz.criteria.EventCriteria;
import io.xhub.xquiz.domain.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface EventService {

    Event getEvent(final String id);
    Page<Event> getEventsByCriteria(Pageable pageable, EventCriteria eventCriteria);

}
