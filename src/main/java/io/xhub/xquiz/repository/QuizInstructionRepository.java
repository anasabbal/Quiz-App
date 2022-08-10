package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.QuizInstruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuizInstructionRepository extends JpaRepository<QuizInstruction, String> {
    List<QuizInstruction> findAllQuizInstructionByDeletedFalse();
}
