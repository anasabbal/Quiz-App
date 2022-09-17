package io.xhub.xquiz.service.question;

import io.xhub.xquiz.command.QuizInstanceDetailsCommand;
import io.xhub.xquiz.domain.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionService {
    List<Question> findListQuestionBySeniorityLevelIdAndSubThemeId(final QuizInstanceDetailsCommand command, final Integer totalQuestions);
    Question getById(final String id);
}
