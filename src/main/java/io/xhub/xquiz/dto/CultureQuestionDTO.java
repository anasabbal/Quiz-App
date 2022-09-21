package io.xhub.xquiz.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CultureQuestionDTO {
    private String id;
    private String content;
    private String type;
    private List<CultureAnswerDTO> cultureAnswers;
}