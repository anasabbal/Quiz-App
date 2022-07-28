package io.xhub.xquiz.command;

import io.xhub.xquiz.core.Validatable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static io.xhub.xquiz.constants.RegexExpressions.*;
import static io.xhub.xquiz.util.Assert.*;

@Getter
@RequiredArgsConstructor
public class UserCommand implements Validatable {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;

    @Override
    public void validate() {
        assertRegex(firstName, ALPHABETIC_MIN_2_CHARS);
        assertRegex(firstName, ALPHABETIC_MIN_2_CHARS);
        assertRegex(email, EMAIL);
        if (phoneNumber != null)
            assertRegex(phoneNumber, PHONE_NUMBER);
    }
}
