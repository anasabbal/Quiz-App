package io.xhub.xquiz.dto;


import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter

public class QuizDetailDTO {
    private List<QuestionDTO> questions;
    private Integer timeLimit;
    private LocalDateTime startDate;

    public static QuizDetailDTO create(List<QuestionDTO> questions, Integer timeLimit, LocalDateTime startDate) {

        final QuizDetailDTO quizDetail = new QuizDetailDTO();

        quizDetail.questions = questions;
        quizDetail.timeLimit = timeLimit;
        quizDetail.startDate = startDate;

        return quizDetail;
    }
}
