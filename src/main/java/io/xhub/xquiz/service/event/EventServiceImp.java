package io.xhub.xquiz.service.event;

import io.xhub.xquiz.dto.EventDTO;
import io.xhub.xquiz.dto.mapper.EventMapper;
import io.xhub.xquiz.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@ConditionalOnProperty(prefix = "fake-service", name = "enabled", havingValue = "false", matchIfMissing = false)
public class EventServiceImp implements EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    @Transactional
    public List<EventDTO> getAllActiveEvents() {
        return eventMapper.toEventDTO(eventRepository.findAllActiveEvents());
    }


}
