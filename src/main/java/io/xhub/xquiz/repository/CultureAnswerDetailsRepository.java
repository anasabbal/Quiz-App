package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.CultureAnswerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CultureAnswerDetailsRepository extends JpaRepository<CultureAnswerDetails, String> {
}
