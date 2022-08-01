package io.xhub.xquiz.service.event;

import io.xhub.xquiz.domain.Event;
import io.xhub.xquiz.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class EventServiceImp implements EventService {
    private final EventRepository eventRepository;

    @Override
    @Transactional
    public List<Event> getAllActiveEvents() {
        return eventRepository.findAllActiveEvents();
    }


}
