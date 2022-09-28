package io.xhub.xquiz.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TechQuizRecapDTO {

    private List<TechQuizRecapAnswersDTO> quizContent;
    private Integer score;
    private Long timePassed;
}
