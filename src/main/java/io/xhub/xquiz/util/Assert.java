package io.xhub.xquiz.util;

import io.xhub.xquiz.exception.BusinessException;
import io.xhub.xquiz.exception.ExceptionPayload;
import io.xhub.xquiz.exception.ExceptionPayloadFactory;

import java.util.List;
import java.util.regex.Pattern;

public interface Assert {

    ExceptionPayload payload = ExceptionPayloadFactory.INVALID_PAYLOAD.get();
    ExceptionPayload formRegistration = ExceptionPayloadFactory.INVALID_FORM_REGISTRATION_PAYLOAD.get();

    static void assertNotNull(Object value, ExceptionPayload exception) {
        if (value == null) throw new BusinessException(exception);
    }

    static void assertNotNull(Object value) {
        if (value == null) throw new BusinessException(payload);
    }

    static void assertStringListNotEmpty(List<String> value) {
        if (value.isEmpty()) throw new BusinessException(payload);
    }

    static void assertRegex(String value, String regex) {
        if (value == null || !Pattern.compile(regex).matcher(value).matches())
            throw new BusinessException(formRegistration);
    }

    static void isValid(Integer value, ExceptionPayload exception) {
        if (value < 1 || value > 5) throw new BusinessException(exception);
    }

    static void assertNotBlank(String value) {
        if (value == null || value.isBlank()) throw new BusinessException(payload);
    }
}
