package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.EventSetup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventSetupRepository extends JpaRepository<EventSetup, String> {
}
