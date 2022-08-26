package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.QuestionAnswerDetails;
import io.xhub.xquiz.domain.QuestionAnswerDetailsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionAnswerDetailsRepository extends JpaRepository<QuestionAnswerDetails, QuestionAnswerDetailsId> {

    @Query("SELECT case when count (q)>0  then true else false end from QuestionAnswerDetails q where q.id.questionDetails.id = :id")
    boolean existsQuestionAnswerDetailsById_QuestionDetails(String id);

}
