package io.xhub.xquiz.service.quizinstance;

import io.xhub.xquiz.domain.QuizInstance;

public interface QuizInstanceService {
    QuizInstance findById(String quizInstanceId);

    void updateStatus(String quizInstanceId);
}
