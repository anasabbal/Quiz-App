package io.xhub.xquiz.service.eventsetup;

import io.xhub.xquiz.domain.EventSetup;
import org.springframework.stereotype.Service;

@Service
public interface EventSetupService {
    EventSetup getEventSetup(final String id);
}
