package io.xhub.xquiz.repository;


import io.xhub.xquiz.domain.CultureAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CultureAnswerRepository extends JpaRepository<CultureAnswer, String> {
}
