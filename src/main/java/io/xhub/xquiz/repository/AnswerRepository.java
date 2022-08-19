package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, String> {

    @Query("SELECT a from Answer a where a.id in :ids AND a.deleted = FALSE ")
    List<Answer> findAnswersByIdAndDeletedFalse(@Param("ids") List<String> ids);

    @Query("select count (a) from Answer a where a.question.id = :id and a.isCorrect = true and a.deleted = false ")
    Integer countCorrectAnswers(String id);
}
