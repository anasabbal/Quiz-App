package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.Attendee;
import io.xhub.xquiz.dto.ParticipantDetailsDTO;
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

    @Query(value = "SELECT new io.xhub.xquiz.dto.ParticipantDetailsDTO(qid.quizInstance.attendeeEvent.id.attendee.id," +
            "                                                          qid.quizInstance.attendeeEvent.id.attendee.firstName, " +
            "                                                          qid.quizInstance.attendeeEvent.id.attendee.lastName, " +
            "                                                          qid.question.seniorityLevel.label, " +
            "                                                          qid.question.subTheme.title, " +
            "                                                          qid.question.subTheme.theme.label, " +
            "                                                          qid.quizInstance.createdAt, g.label, " +
            "                                                          qid.quizInstance.finalScore * 100 /  sum(qid.question.score), 0L) " +
            "FROM QuizInstanceDetails qid " +
            "LEFT JOIN Goody g on qid.quizInstance.attendeeEvent.goody = g " +
            "WHERE qid.quizInstance.status = 'FINISHED' " +
            "   AND upper(concat(qid.quizInstance.attendeeEvent.id.attendee.firstName, qid.quizInstance.attendeeEvent.id.attendee.lastName)) " +
            "   LIKE concat('%', upper(replace(:keyword, ' ', ''))  ,'%')" +
            "GROUP BY qid.quizInstance.attendeeEvent.id.attendee.id, " +
            "         qid.quizInstance.attendeeEvent.id.attendee.firstName, " +
            "         qid.quizInstance.attendeeEvent.id.attendee.lastName, " +
            "         qid.question.seniorityLevel.label, " +
            "         qid.question.subTheme.title, " +
            "         qid.question.subTheme.theme.label, " +
            "         qid.quizInstance.createdAt, " +
            "         qid.quizInstance.finalScore, " +
            "         g.label")
    Page<ParticipantDetailsDTO> findAllParticipantDetailsByCriteria(String keyword, Pageable pageable);


}
