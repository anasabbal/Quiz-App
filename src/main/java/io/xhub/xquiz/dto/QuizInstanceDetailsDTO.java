package io.xhub.xquiz.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class QuizInstanceDetailsDTO {
    private String id;
    private List<QuestionDTO> questions;
    private LocalDateTime startDate;
    private int timeLimit;
}