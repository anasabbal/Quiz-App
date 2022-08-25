package io.xhub.xquiz.command;


import io.xhub.xquiz.core.Validatable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static io.xhub.xquiz.util.Assert.*;

@Getter
@RequiredArgsConstructor
public class RatingCommand implements Validatable {

    private final String content;
    private final Integer ratingScore;

    @Override
    public void validate() {
        assertNotNull(content);
        assertNotNull(ratingScore);
        isValid(ratingScore);
    }
}
