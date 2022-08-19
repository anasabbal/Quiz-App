package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.QuizInstanceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizInstanceDetailRepository extends JpaRepository<QuizInstanceDetails, String> {

    QuizInstanceDetails findQuizInstanceDetailsByQuizInstanceIdAndQuestionIndex(String id, Integer questionIndex);

    boolean existsByQuizInstanceId(String id);
}
