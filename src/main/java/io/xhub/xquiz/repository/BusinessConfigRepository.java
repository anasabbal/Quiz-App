package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.config.BusinessConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusinessConfigRepository extends JpaRepository<BusinessConfig, String> {

    Optional<BusinessConfig> findByKey(String key);
}

