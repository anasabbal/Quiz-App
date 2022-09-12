package io.xhub.xquiz.service.eventsetup;

import io.xhub.xquiz.domain.EventSetup;
import io.xhub.xquiz.exception.BusinessException;
import io.xhub.xquiz.exception.ExceptionPayloadFactory;
import io.xhub.xquiz.repository.EventSetupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventSetupServiceImpl implements EventSetupService {

    private final EventSetupRepository eventSetupRepository;

    @Override
    public EventSetup getEventSetup(final String id) {
        log.info("Begin fetching event setup with id {}", id);
        return eventSetupRepository.findById(id).orElseThrow(
                () -> new BusinessException(ExceptionPayloadFactory.EVENT_SETUP_NOT_FOUND.get()));
    }
}
