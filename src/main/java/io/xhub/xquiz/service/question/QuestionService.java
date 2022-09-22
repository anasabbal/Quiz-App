package io.xhub.xquiz.service.question;

import io.xhub.xquiz.command.QuizInstanceDetailsCommand;
import io.xhub.xquiz.domain.Question;

import java.util.List;

public interface QuestionService {
    Question getById(final String id);
    List<Question> findQuestionsByPercentage(final QuizInstanceDetailsCommand command, final Integer totalQuestions);
}
