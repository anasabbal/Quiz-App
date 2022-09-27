package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.Attendee;
import io.xhub.xquiz.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {
    Optional<Rating> findRatingByAttendee(Attendee attendee);

    @Query(value = "select r from Rating r where r.attendee.id = :attendeeId and r.deleted = false ")
    Optional<Rating> findRatingByAttenteeId(String attendeeId);
}