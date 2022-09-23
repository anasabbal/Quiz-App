package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.Attendee;
import io.xhub.xquiz.domain.projection.ParticipantDetailDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, String> {

    Boolean existsByEmail(String email);

    Optional<Attendee> findByEmail(String email);

    @Query(value = "SELECT new io.xhub.xquiz.domain.projection.ParticipantDetailDTO(" +
            "                                                qid.quizInstance.attendeeEvent.id.attendee.id, " +
            "                                                qid.quizInstance.attendeeEvent.id.event.id," +
            "                                                qid.quizInstance.attendeeEvent.id.attendee.firstName, " +
            "                                                qid.quizInstance.attendeeEvent.id.attendee.lastName, " +
            "                                                qid.question.seniorityLevel.label, " +
            "                                                qid.question.subTheme.title, " +
            "                                                qid.question.subTheme.theme.label, " +
            "                                                qid.quizInstance.createdAt, g.label, " +
            "                                                qid.quizInstance.percentFinalScore, cqd.percentFinalScore * 5 / 100) " +
            "       FROM QuizInstanceDetails qid" +
            "       JOIN CultureQuizDetails cqd on qid.quizInstance = cqd.quizInstance" +
            "       LEFT JOIN Goody g on qid.quizInstance.attendeeEvent.goody = g " +
            "       GROUP BY qid.quizInstance.attendeeEvent.id.attendee.id," +
            "                qid.quizInstance.attendeeEvent.id.event.id," +
            "                qid.quizInstance.attendeeEvent.id.attendee.firstName," +
            "                qid.quizInstance.attendeeEvent.id.attendee.lastName," +
            "                qid.question.seniorityLevel.label," +
            "                qid.question.subTheme.title," +
            "                qid.question.subTheme.theme.label," +
            "                qid.quizInstance.createdAt," +
            "                qid.quizInstance.finalScore," +
            "                qid.quizInstance.status," +
            "                qid.quizInstance.percentFinalScore," +
            "                cqd.percentFinalScore," +
            "                g.label" +
            "        HAVING qid.quizInstance.status = 'FINISHED' and qid.quizInstance.attendeeEvent is not null" +
            "        AND upper(concat(qid.quizInstance.attendeeEvent.id.attendee.firstName, qid.quizInstance.attendeeEvent.id.attendee.lastName)) " +
            "        LIKE concat('%', upper(replace(:keyword, ' ', ''))  ,'%')")
    Page<ParticipantDetailDTO> findAllParticipantDetailsByCriteria(String keyword, Pageable pageable);


}
