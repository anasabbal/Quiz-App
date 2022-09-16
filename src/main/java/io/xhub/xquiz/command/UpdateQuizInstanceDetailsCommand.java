package io.xhub.xquiz.command;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UpdateQuizInstanceDetailsCommand {

    private List<String> answersId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String questionId;
}
