package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, String> {

    Boolean existsByEmail(String email);
    Optional<Attendee> findByEmail(String email);
}
