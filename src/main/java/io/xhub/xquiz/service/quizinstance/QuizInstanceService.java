package io.xhub.xquiz.service.quizinstance;

import io.xhub.xquiz.command.CreateEventSessionCommand;
import io.xhub.xquiz.command.QuizInstanceDetailsCommand;
import io.xhub.xquiz.domain.QuizInstance;
import io.xhub.xquiz.domain.QuizInstanceDetails;
import io.xhub.xquiz.dto.QuizDetailDTO;
import io.xhub.xquiz.dto.QuizInstructionDTO;

import java.util.List;

public interface QuizInstanceService {

    QuizInstance findById(String quizInstanceId);

    void updateStatus(String quizInstanceId);

    QuizInstance createSession(final CreateEventSessionCommand body);

    List<QuizInstructionDTO> getQuizInstructions();

    void updateLastQuestionIndex(String id, QuizInstanceDetails quizInstanceDetails);

    QuizDetailDTO startQuiz(QuizInstanceDetailsCommand quizInstanceDetailsCommand);
}
