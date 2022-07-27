package io.xhub.xquiz.util;

import io.xhub.xquiz.exception.BusinessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.xhub.xquiz.constants.RegexExpressions.*;
import static org.junit.jupiter.api.Assertions.*;

class AssertTest {

    @Test
    @DisplayName("given null value when assertNotNull called then throw invalid payload exception")
    void should_throw_invalid_payload_exception_given_null_object() {
        assertThrows(BusinessException.class, () -> Assert.assertNotNull(null));
    }

    @Test
    @DisplayName("given not null value when assertNotNull called then dont throw invalid payload exception")
    void should_not_throw_invalid_payload_exception_given_not_null_object() {
        assertDoesNotThrow(() -> Assert.assertNotNull("not null"));
    }

    @Test
    @DisplayName("given invalid email when assertRegex called then throw invalid payload exception")
    void should_throw_invalid_payload_exception_given_invalid_email() {
        assertThrows(BusinessException.class, () -> Assert.assertRegex("invalid email", EMAIL));
    }

    @Test
    @DisplayName("given valid email when assertRegex called then dont throw invalid payload exception")
    void should_not_throw_invalid_payload_exception_given_working_email() {
        assertDoesNotThrow(() -> Assert.assertRegex("email@domain.com", EMAIL));
    }

    @Test
    @DisplayName("given invalid phone number when assertRegex called then throw invalid payload exception")
    void should_throw_invalid_payload_exception_given_invalid_phone_number() {
        assertThrows(BusinessException.class, () -> Assert.assertRegex("+212 NOT WORKING", PHONE_NUMBER));
    }

    @Test
    @DisplayName("given valid phone number when assertRegex called then dont throw invalid payload exception")
    void should_not_throw_invalid_payload_exception_given_working_phone_number() {
        assertDoesNotThrow(() -> Assert.assertRegex("+212661616161", PHONE_NUMBER));
    }

    @Test
    @DisplayName("given invalid name when assertRegex called then throw invalid payload exception")
    void should_throw_invalid_payload_exception_given_invalid_value() {
        assertThrows(BusinessException.class, () -> Assert.assertRegex("A", ALPHABETIC_MIN_2_CHARS));
    }

    @Test
    @DisplayName("given valid name when assertRegex called then dont throw invalid payload exception")
    void should_not_throw_invalid_payload_exception_given_valid_value() {
        assertDoesNotThrow(() -> Assert.assertRegex("WORKING", ALPHABETIC_MIN_2_CHARS));
    }

}