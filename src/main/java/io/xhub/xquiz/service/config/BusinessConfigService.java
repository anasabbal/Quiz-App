package io.xhub.xquiz.service.config;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BusinessConfigService {

    @Transactional(readOnly = true)
    String getValue(String key);

    @Transactional(readOnly = true)
    Float getFloatValue(String key);
}
