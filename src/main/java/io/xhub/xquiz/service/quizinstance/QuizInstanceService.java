package io.xhub.xquiz.service.quizinstance;

import io.xhub.xquiz.command.CreateEventSessionCommand;
import io.xhub.xquiz.command.QuizInstanceDetailsCommand;
import io.xhub.xquiz.command.UpdateQuizInstanceDetailsCommand;
import io.xhub.xquiz.domain.Attendee;
import io.xhub.xquiz.domain.QuizInstance;
import io.xhub.xquiz.domain.QuizInstanceDetails;
import io.xhub.xquiz.domain.QuizInstruction;
import io.xhub.xquiz.dto.PassMarkDTO;
import io.xhub.xquiz.dto.QuestionDTO;
import io.xhub.xquiz.dto.QuizDetailDTO;
import io.xhub.xquiz.dto.QuizInstructionDTO;

import java.util.List;

public interface QuizInstanceService {

    QuizInstance findById(String quizInstanceId);
    void updateStatus(String quizInstanceId);
    QuizInstance createSession(final CreateEventSessionCommand body);
    List<QuizInstructionDTO> getQuizInstructions();
    void updateLastQuestionIndexAndFinalScore(QuizInstanceDetails quizInstanceDetails, QuizInstance quizInstance);
    QuizDetailDTO startQuiz(QuizInstanceDetailsCommand quizInstanceDetailsCommand);
    Attendee getAttendeeByQuizInstanceId(final String id);
    QuizInstruction getQuizInstructionsByKey(final String key);
    QuestionDTO answer(final String quizInstanceId,final UpdateQuizInstanceDetailsCommand command);
    PassMarkDTO finishQuiz(final String quizInstanceId);
}
