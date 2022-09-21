package io.xhub.xquiz.service.question;

import io.xhub.xquiz.command.QuizInstanceDetailsCommand;
import io.xhub.xquiz.domain.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findListQuestionBySeniorityLevelIdAndSubThemeId(final QuizInstanceDetailsCommand command, final Integer totalQuestions);
    Question getById(final String id);
}
