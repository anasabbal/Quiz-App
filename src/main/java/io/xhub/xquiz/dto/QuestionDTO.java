package io.xhub.xquiz.dto;



import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionDTO {
    private String id;
    private String content;
    private Boolean isMultipleChoice;
    private Integer index;
    private List<AnswerDTO> answers;
}
