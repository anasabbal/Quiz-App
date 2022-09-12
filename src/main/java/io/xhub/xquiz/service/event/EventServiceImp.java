package io.xhub.xquiz.service.event;

import io.xhub.xquiz.criteria.EventCriteria;
import io.xhub.xquiz.domain.Event;
import io.xhub.xquiz.exception.BusinessException;
import io.xhub.xquiz.exception.ExceptionPayloadFactory;
import io.xhub.xquiz.repository.EventRepository;
import io.xhub.xquiz.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@ConditionalOnProperty(prefix = "fake-service", name = "enabled", havingValue = "false", matchIfMissing = false)
@Slf4j
public class EventServiceImp implements EventService {

    private final EventRepository eventRepository;

    @Override
    public Event getEvent(String id) {
        log.info("Begin fetching event with id {}", id);
        return eventRepository.findEventByIdAndDeletedFalse(id).orElseThrow(
                () -> new BusinessException(ExceptionPayloadFactory.EVENT_NOT_FOUND.get()));
    }

    @Override
    public Page<Event> getEventsByCriteria(Pageable pageable, EventCriteria eventCriteria) {
        log.info("Begin fetching events with criteria payload {}", JSONUtil.toJSON(eventCriteria));
        return eventRepository.findAllEventsSortByDateWithCriteria(pageable, eventCriteria);
    }

}
