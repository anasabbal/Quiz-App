package io.xhub.xquiz.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditConfiguration {

    @Bean
    public AuditorAware<String> auditorProvider() {
        // TODO : take into consideration the authenticated user
        return () -> Optional.of("SYSTEM");
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

