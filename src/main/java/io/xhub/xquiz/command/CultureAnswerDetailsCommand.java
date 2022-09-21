package io.xhub.xquiz.command;

import lombok.Data;

import java.util.List;

@Data
public class CultureAnswerDetailsCommand {

    private String questionId;
    private List<String> answersId;
    private String content;
}
