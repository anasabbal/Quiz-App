package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.Attendee;
import io.xhub.xquiz.domain.CultureQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CultureQuestionRepository extends JpaRepository<CultureQuestion, String> {

    List<CultureQuestion> findAllByDeletedFalse();
}
