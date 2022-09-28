package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.Goody;
import io.xhub.xquiz.domain.projection.ParticipantGoodiesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GoodyRepository extends JpaRepository<Goody, String> {

    Optional<Goody> findByIdAndDeletedFalse(String s);
    @Query(value = "SELECT new io.xhub.xquiz.domain.projection.ParticipantGoodiesDTO(" +
            "                                                g.id, " +
            "                                                g.label, " +
            "                                                g.availableStock, " +
            "                                                case when ((qid.quizInstance.finalScorePercentage * :techQuizFactor) / 100)  +  ((cqd.finalScorePercentage * :cultQuizFactor) / 100)  >= g.winScoreThreshold then true else false end, " +
            "                                                case when g = qi.attendeeEvent.goody then true else false end)" +
            "       FROM Goody g" +
            "       JOIN QuizInstance qi on qi.attendeeEvent.id.event.id = :eventID" +
            "       AND qi.attendeeEvent.id.attendee.id = :participantID" +
            "       JOIN QuizInstanceDetails qid on qid.quizInstance = qi" +
            "       JOIN CultureQuizDetails cqd on cqd.quizInstance = qi" +
            "       GROUP BY g.id, qid.quizInstance.finalScorePercentage, " +
            "                      cqd.finalScorePercentage," +
            "                      qi.attendeeEvent.goody order by g.winScoreThreshold")
    List<ParticipantGoodiesDTO> findAllEventParticipantGoodies(String eventID, String participantID, Float techQuizFactor, Float cultQuizFactor);




}
