package io.xhub.xquiz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TechQuizRecapAnswersDTO {

    private String id;
    private String question;
    private List<QuizAnswerDTO> answers;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class QuizAnswerDTO {

        private String id;
        private String label;
        private Boolean isCorrect;
        private Boolean isSelected;
    }
}
