package io.xhub.xquiz.dto;

import io.xhub.xquiz.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class QuizInstanceDTO {

    private String id;
    private Status status;
    private LocalDateTime startDate;

}
