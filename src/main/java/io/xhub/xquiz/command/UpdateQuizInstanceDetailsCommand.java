package io.xhub.xquiz.command;

import io.xhub.xquiz.core.Validatable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

import static io.xhub.xquiz.util.Assert.assertNotNull;
import static io.xhub.xquiz.util.Assert.assertStringListNotEmpty;

@Getter
@Setter
public class UpdateQuizInstanceDetailsCommand implements Validatable {

    private List<String> answersId;

    @Override
    public void validate() {
        assertNotNull(answersId);
        assertStringListNotEmpty(answersId);
    }
}
