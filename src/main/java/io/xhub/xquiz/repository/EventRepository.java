package io.xhub.xquiz.repository;

import io.xhub.xquiz.criteria.EventCriteria;
import io.xhub.xquiz.domain.Event;
import io.xhub.xquiz.util.PatternUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static io.xhub.xquiz.domain.Event_.*;

@Repository
public interface EventRepository extends JpaRepository<Event, String>, JpaSpecificationExecutor<Event> {
    Optional<Event> findEventByIdAndDeletedFalse(String id);

    default Page<Event> findAllEventsSortByDateWithCriteria(Pageable pageable, EventCriteria eventCriteria) {
        return findAll((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>(Arrays.asList(
                    builder.lessThanOrEqualTo(root.get(START_DATE), LocalDateTime.now()),
                    builder.greaterThanOrEqualTo(root.get(END_DATE), LocalDateTime.now())
            ));
            if (eventCriteria.getName() != null) {
                String pattern = PatternUtil.likePattern(eventCriteria.getName().toUpperCase());
                predicates.add(builder.like(builder.upper(root.get(NAME)), pattern));
            }
            if (eventCriteria.getActive() != null) {
                predicates.add(builder.equal(root.get(ACTIVE), eventCriteria.getActive()));
            }
            query.orderBy(builder.desc(root.get(START_DATE)));
            return builder.and(predicates.toArray(new Predicate[]{}));

        }, pageable);
    }
}
