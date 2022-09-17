package io.xhub.xquiz.service.quizInstanceDetails;

import io.xhub.xquiz.domain.QuizInstanceDetails;

public interface QuizInstanceDetailsService {

    QuizInstanceDetails getQuizInstanceDetails(String quizInstanceId, String questionId);
    QuizInstanceDetails getQuizInstanceDetailsByQuestionIndex(String quizInstanceId, Integer questionIndex);
    void save(final QuizInstanceDetails quizInstanceDetails);
    QuizInstanceDetails findQuizInstanceDetailsByQuizInstanceAndQuestionIndex(final String id, final Integer index);
    Boolean checkIfSessionQuestionsExist(final String id);
    Integer sumQuestionScore(final String id);
}
