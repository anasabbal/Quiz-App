package io.xhub.xquiz.command;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class QuizInstanceDetailsCommand {
    private String seniorityLevelId;
    private String themeId;
    private String sessionId;
}
