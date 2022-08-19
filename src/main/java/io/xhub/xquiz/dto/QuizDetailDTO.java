package io.xhub.xquiz.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter

public class QuizDetailDTO {
    private QuestionDTO question;
    private Integer timeLimit;
    private LocalDateTime startDate;

    public static QuizDetailDTO create(QuestionDTO question, Integer timeLimit, LocalDateTime startDate) {

        final QuizDetailDTO quizDetail = new QuizDetailDTO();

        quizDetail.question = question;
        quizDetail.timeLimit = timeLimit;
        quizDetail.startDate = startDate;

        return quizDetail;
    }
}
