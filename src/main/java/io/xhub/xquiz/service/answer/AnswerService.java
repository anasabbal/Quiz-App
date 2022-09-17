package io.xhub.xquiz.service.answer;

import io.xhub.xquiz.command.UpdateQuizInstanceDetailsCommand;
import io.xhub.xquiz.domain.Answer;
import io.xhub.xquiz.domain.Question;
import io.xhub.xquiz.domain.QuizInstanceDetails;

import java.util.List;

public interface AnswerService {

    Integer countCorrectAnswers(final String id);
    Question getQuestion(final UpdateQuizInstanceDetailsCommand command,final List<Answer> answers);
    void createQuestionAnswerDetails(List<Answer> answers, QuizInstanceDetails quizInstanceDetails);
    List<Answer> getAnswersByIds(List<String> ids);
    Boolean answerVerification(List<Answer> answers, Question question);
}
