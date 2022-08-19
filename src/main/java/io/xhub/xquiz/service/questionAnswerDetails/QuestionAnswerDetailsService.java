package io.xhub.xquiz.service.questionAnswerDetails;

import io.xhub.xquiz.domain.Answer;
import io.xhub.xquiz.domain.QuestionAnswerDetails;
import io.xhub.xquiz.domain.QuizInstanceDetails;

public interface QuestionAnswerDetailsService {
    QuestionAnswerDetails create(final Answer answer, final QuizInstanceDetails questionDetails);

}
