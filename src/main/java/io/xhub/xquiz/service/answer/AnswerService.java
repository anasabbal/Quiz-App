package io.xhub.xquiz.service.answer;

import io.xhub.xquiz.command.UpdateQuizInstanceDetailsCommand;
import io.xhub.xquiz.domain.Answer;
import io.xhub.xquiz.dto.QuestionDTO;

public interface AnswerService {

    QuestionDTO answer(String quizInstanceId, UpdateQuizInstanceDetailsCommand command);
}