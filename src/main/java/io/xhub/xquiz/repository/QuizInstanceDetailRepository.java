package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.QuizInstanceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuizInstanceDetailRepository extends JpaRepository<QuizInstanceDetails, String> {
}
