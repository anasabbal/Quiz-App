package io.xhub.xquiz.dto;



import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class QuestionDTO {
    private String id;
    private String content;
    private Boolean isMultipleChoice;
}
