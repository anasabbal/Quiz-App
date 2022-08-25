package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.QuizInstanceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizInstanceDetailRepository extends JpaRepository<QuizInstanceDetails, String> {

    QuizInstanceDetails findQuizInstanceDetailsByQuizInstanceIdAndQuestionIndex(String id, Integer questionIndex);

    @Query("SELECT q from QuizInstanceDetails q where q.quizInstance.id = ?1  and q.question.id = ?2 and q.deleted=false")
    Optional<QuizInstanceDetails> findQuizInstanceDetails(String quizInstanceId, String questionId);

    boolean existsByQuizInstanceId(String id);

    @Query("SELECT sum (q.question.score) from QuizInstanceDetails q where q.quizInstance.id =?1 and q.deleted=false ")
    Integer sumQuestionsScoreByQuizInstanceId(String id);

}
