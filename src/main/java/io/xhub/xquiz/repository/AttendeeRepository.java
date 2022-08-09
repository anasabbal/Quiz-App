package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, String> {

    Boolean existsByEmail(String email);
}
