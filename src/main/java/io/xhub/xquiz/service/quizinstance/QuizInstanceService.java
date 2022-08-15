package io.xhub.xquiz.service.quizinstance;

import io.xhub.xquiz.command.CreateEventSessionCommand;
import io.xhub.xquiz.command.QuizInstanceDetailsCommand;
import io.xhub.xquiz.domain.QuizInstance;
import io.xhub.xquiz.dto.QuizInstanceDetailsDTO;
import io.xhub.xquiz.dto.QuizInstructionDTO;

import java.util.List;

public interface QuizInstanceService {

    QuizInstance findById(String quizInstanceId);

    void updateStatus(String quizInstanceId);

    QuizInstance createSession(final CreateEventSessionCommand body);

    List<QuizInstructionDTO> getQuizInstructions();
    QuizInstanceDetailsDTO startQuiz(QuizInstanceDetailsCommand quizInstanceDetailsCommand);
}
