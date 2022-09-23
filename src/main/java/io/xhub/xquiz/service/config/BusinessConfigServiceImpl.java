package io.xhub.xquiz.service.config;

import io.xhub.xquiz.domain.config.BusinessConfig;
import io.xhub.xquiz.exception.TechnicalException;
import io.xhub.xquiz.repository.BusinessConfigRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BusinessConfigServiceImpl implements BusinessConfigService {

    private final BusinessConfigRepository configRepository;

    private BusinessConfig getBusinessConfig(String key) {
        log.info("Fetching business config for key '{}'", key);
        return configRepository.findByKey(key).orElseThrow(() -> {
            log.error("No business config found for key '{}'", key);
            return new TechnicalException("No business config found for key " + key);
        });
    }

    @Override
    public String getValue(String key) {
        return getBusinessConfig(key).getValue();
    }

    @Override
    public Float getFloatValue(String key) {
        return Float.valueOf(getBusinessConfig(key).getValue());
    }
}
