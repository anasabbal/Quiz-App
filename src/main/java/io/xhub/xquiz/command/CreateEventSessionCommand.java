package io.xhub.xquiz.command;

import io.xhub.xquiz.core.Validatable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

import static io.xhub.xquiz.constants.RegexExpressions.*;
import static io.xhub.xquiz.util.Assert.assertRegex;

@Getter
@RequiredArgsConstructor
public class CreateEventSessionCommand implements Validatable {
    private final String eventId;
    private final String eventSetupId;

    private final Map<String, String> payload;

    @Override
    public void validate() {
        assertRegex(payload.get("firstname"), ALPHABETIC_MIN_2_CHARS);
        assertRegex(payload.get("lastname"), ALPHABETIC_MIN_2_CHARS);
        assertRegex(payload.get("email"), EMAIL);
        if (payload.get("phone") != null)
            assertRegex(payload.get("phone"), PHONE_NUMBER);
    }
}
