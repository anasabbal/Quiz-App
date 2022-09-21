package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.CultureQuizDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CultureQuizDetailsRepository extends JpaRepository<CultureQuizDetails, String> {

    Boolean existsByQuizInstanceIdAndDeletedFalse(String quizInstanceId);
}
