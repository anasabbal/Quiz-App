package io.xhub.xquiz.service.quizinstruction;

import io.xhub.xquiz.domain.QuizInstruction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizInstructionsService {
    List<QuizInstruction> findAllQuizInstruction();
    QuizInstruction findQuizInstructionByKey(final String key);
}
