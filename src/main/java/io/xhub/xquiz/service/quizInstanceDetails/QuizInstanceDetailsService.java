package io.xhub.xquiz.service.quizInstanceDetails;

import io.xhub.xquiz.domain.QuizInstanceDetails;

public interface QuizInstanceDetailsService {

    QuizInstanceDetails getQuizInstanceDetails(String quizInstanceId, String questionId);

    QuizInstanceDetails getQuizInstanceDetailsByQuestionIndex(String quizInstanceId, Integer questionIndex);
}
