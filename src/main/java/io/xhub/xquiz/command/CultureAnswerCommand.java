package io.xhub.xquiz.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class CultureAnswerCommand {
    private final String quizInstanceId;
    private final List<CultureAnswerDetailsCommand> answers;
}
