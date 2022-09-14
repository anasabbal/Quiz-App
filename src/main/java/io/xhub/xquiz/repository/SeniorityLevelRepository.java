package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.SeniorityLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface SeniorityLevelRepository extends JpaRepository<SeniorityLevel, String> {
    List<SeniorityLevel> findAllByDeletedFalse();
}
