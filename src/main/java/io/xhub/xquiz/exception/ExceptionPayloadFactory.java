package io.xhub.xquiz.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionPayloadFactory {

    TECHNICAL_ERROR(0, HttpStatus.INTERNAL_SERVER_ERROR, "technical.error"),
    INVALID_PAYLOAD(1, HttpStatus.BAD_REQUEST, "invalid.request.payload"),
    ATTENDEE_NOT_FOUND(2, HttpStatus.BAD_REQUEST, "attendee.not.found"),

    SENIORITY_LEVEL_NOT_FOUND(3, HttpStatus.BAD_REQUEST, "seniority.level.not.found"),
    EVENT_NOT_FOUND(6, HttpStatus.NOT_FOUND, "events.not.found"),
    EVENT_SETUP_NOT_FOUND(7, HttpStatus.NOT_FOUND, "events.setup.not.found"),
    FILE_NOT_FOUND(5, HttpStatus.NOT_FOUND, "file.not.found"),
    ATTENDEE_ALREADY_EXISTS(8, HttpStatus.BAD_REQUEST, "attendee.already.exists"),
    QUIZ_INSTANCE_NOT_FOUND(9, HttpStatus.NOT_FOUND, "quiz.instance.not.found"),
    THEME_NOT_FOUND(10, HttpStatus.NOT_FOUND, "theme.not.found");

    private final Integer code;
    private final HttpStatus status;
    private final String message;

    public ExceptionPayload get() {
        return new ExceptionPayload(code, status, message);
    }

}
