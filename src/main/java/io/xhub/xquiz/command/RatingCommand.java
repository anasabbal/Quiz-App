package io.xhub.xquiz.command;


import io.xhub.xquiz.core.Validatable;
import io.xhub.xquiz.exception.ExceptionPayload;
import io.xhub.xquiz.exception.ExceptionPayloadFactory;
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
        ExceptionPayload payload = ExceptionPayloadFactory.INVALID_RATING_PAYLOAD.get();
        assertNotNull(content, payload);
        assertNotNull(ratingScore, payload);
        isValid(ratingScore, payload);
    }
}
