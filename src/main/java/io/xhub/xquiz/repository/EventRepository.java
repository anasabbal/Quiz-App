package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {


    @Query(value = "SELECT e from  Event e where e.endDate>=current_date and e.deleted=false  and e.active=true")
    List<Event> findAllActiveEvents();
}
