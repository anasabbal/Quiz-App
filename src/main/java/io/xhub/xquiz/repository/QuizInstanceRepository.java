package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.Attendee;
import io.xhub.xquiz.domain.AttendeeEvent;
import io.xhub.xquiz.domain.QuizInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizInstanceRepository extends JpaRepository<QuizInstance, String> {

    @Query("SELECT q FROM QuizInstance q WHERE q.attendeeEvent = ?1")
    Optional<QuizInstance> findByAttendeeEvent(AttendeeEvent attendeeEvent);

    @Query("SELECT q.attendeeEvent.id.attendee FROM QuizInstance q WHERE q.id = ?1")
    Optional<Attendee> findAttendeeByQuizInstance(final String id);
}
