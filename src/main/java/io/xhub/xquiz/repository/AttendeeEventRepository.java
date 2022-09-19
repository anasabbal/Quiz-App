package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.Attendee;
import io.xhub.xquiz.domain.AttendeeEvent;
import io.xhub.xquiz.domain.AttendeeEventId;
import io.xhub.xquiz.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttendeeEventRepository extends JpaRepository<AttendeeEvent, AttendeeEventId> {
    @Query("SELECT ae FROM AttendeeEvent ae WHERE ae.id.attendee.email = ?1 AND ae.id.event.id = ?2")
    Optional<AttendeeEvent> findByAttendeeAndEvent(String email, String id);

    @Query("SELECT qi.attendeeEvent from QuizInstance qi " +
           "WHERE qi.attendeeEvent.id.event = :event and qi.attendeeEvent.id.attendee.id = :participantID  and qi.status = 'FINISHED'")
    Optional<AttendeeEvent> findEventParticipantByID(Event event, String participantID);

    @Query("SELECT count(qi.attendeeEvent.id.attendee) from QuizInstance qi where qi.attendeeEvent.id.event = :event and qi.status = 'FINISHED'")
    int countEventParticipants(Event event);

    @Query("SELECT qid.quizInstance.finalScore * 100 / sum(qid.question.score) from QuizInstanceDetails qid " +
           "WHERE qid.quizInstance.attendeeEvent.id.event = :event " +
            "   and qid.quizInstance.attendeeEvent.id.attendee = :participant " +
            "   and qid.quizInstance.status = 'FINISHED'" +
            "GROUP BY qid.quizInstance.finalScore, qid.question.score")
    float getEventParticipantTechnicalQuizScore(Event event, Attendee participant);
}
