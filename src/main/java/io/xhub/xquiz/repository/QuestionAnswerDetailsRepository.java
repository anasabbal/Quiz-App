package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.Answer;
import io.xhub.xquiz.domain.QuestionAnswerDetails;
import io.xhub.xquiz.domain.QuestionAnswerDetailsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionAnswerDetailsRepository extends JpaRepository<QuestionAnswerDetails, QuestionAnswerDetailsId> {

    @Query("SELECT case when count (q)>0  then true else false end from QuestionAnswerDetails q where q.id.questionDetails.id = :id")
    boolean existsQuestionAnswerDetailsById_QuestionDetails(String id);

    @Query("SELECT qad.id.answer " +
            "FROM QuestionAnswerDetails qad " +
            "where qad.id.questionDetails.quizInstance.attendeeEvent.id.event.id = :eventID " +
            "and qad.id.questionDetails.quizInstance.attendeeEvent.id.attendee.id = :participantID " +
            "and qad.id.questionDetails.quizInstance.status = 'FINISHED'")
    List<Answer> findParticipantTechnicalQuizAnswers(String eventID, String participantID);




}
