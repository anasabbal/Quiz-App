package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.AttendeeEvent;
import io.xhub.xquiz.domain.AttendeeEventId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttendeeEventRepository extends JpaRepository<AttendeeEvent, AttendeeEventId> {
    @Query("SELECT ae FROM AttendeeEvent ae WHERE ae.id.attendee.email = ?1 AND ae.id.event.id = ?2")
    Optional<AttendeeEvent> findByAttendeeAndEvent(String email, String id);

    @Query("SELECT qi.attendeeEvent from QuizInstance qi " +
            "WHERE qi.attendeeEvent.id.event.id = :eventID and qi.attendeeEvent.id.attendee.id = :participantID  and qi.status = 'FINISHED'")
    Optional<AttendeeEvent> findEventParticipantByID(String eventID, String participantID);

    @Query("SELECT qi.percentFinalScore * 100 from QuizInstance qi " +
            "WHERE qi.attendeeEvent.id.event.id = :eventID " +
            "and qi.attendeeEvent.id.attendee.id = :participantID " +
            "and qi.status = 'FINISHED'")
    Integer getEventParticipantTechnicalQuizPercentScore(String eventID, String participantID);

    @Query("SELECT cqd.percentFinalScore * 100 from CultureQuizDetails cqd " +
            "WHERE cqd.quizInstance.attendeeEvent.id.event.id = :eventID " +
            "and cqd.quizInstance.attendeeEvent.id.attendee.id = :participantID " +
            "and cqd.quizInstance.status = 'FINISHED'")
    Integer getEventParticipantCulturalQuizPercentScore(String eventID, String participantID);
}
