package io.xhub.xquiz.service.quizinstance;

import io.xhub.xquiz.domain.QuizInstance;
import io.xhub.xquiz.domain.QuizInstruction;
import io.xhub.xquiz.dto.QuizInstructionDTO;

import java.util.List;

public interface QuizInstanceService {
    QuizInstance findById(String quizInstanceId);

    void updateStatus(String quizInstanceId);
    List<QuizInstructionDTO> getQuizInstructions();
}
