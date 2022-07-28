package io.xhub.xquiz.util;

import io.xhub.xquiz.exception.*;

import java.util.regex.Pattern;

public interface Assert {

    ExceptionPayload payload = ExceptionPayloadFactory.INVALID_PAYLOAD.get();

    static void assertNotNull(Object value, ExceptionPayload exception) {
        if (value == null) {
            throw new BusinessException(exception);
        }
    }

    static void assertRegex(String value, String regex) {
        if (value == null || !Pattern.compile(regex).matcher(value).matches()) throw new BusinessException(payload);
    }

}
