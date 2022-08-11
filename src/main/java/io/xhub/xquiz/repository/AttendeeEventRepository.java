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
}
