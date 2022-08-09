package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.QuizInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuizInstanceRepository extends JpaRepository<QuizInstance, String> {
}
