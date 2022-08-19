package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.QuestionAnswerDetails;
import io.xhub.xquiz.domain.QuestionAnswerDetailsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionAnswerDetailsRepository extends JpaRepository<QuestionAnswerDetails, QuestionAnswerDetailsId> {

}
