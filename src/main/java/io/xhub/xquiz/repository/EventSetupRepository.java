package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.EventSetup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventSetupRepository extends JpaRepository<EventSetup, String> {
    Optional<EventSetup> findById(final String id);
}
