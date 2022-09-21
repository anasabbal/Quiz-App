package io.xhub.xquiz.service.CultureQuestion;

import io.xhub.xquiz.command.CultureAnswerCommand;
import io.xhub.xquiz.domain.CultureQuestion;

import java.util.List;

public interface CultureQuestionService {

    List<CultureQuestion> getAllQuestions(String quizInstanceId);
    void answer(final CultureAnswerCommand command);
}
