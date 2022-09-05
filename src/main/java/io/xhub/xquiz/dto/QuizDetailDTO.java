package io.xhub.xquiz.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class QuizDetailDTO {
    private QuestionDTO question;
    private Integer timeLimit;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public static QuizDetailDTO create(QuestionDTO question, Integer timeLimit, LocalDateTime startDate, LocalDateTime endDate) {

        final QuizDetailDTO quizDetail = new QuizDetailDTO();

        quizDetail.question = question;
        quizDetail.timeLimit = timeLimit;
        quizDetail.startDate = startDate;
        quizDetail.endDate = endDate;
        return quizDetail;
    }
}
