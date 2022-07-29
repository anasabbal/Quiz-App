package io.xhub.xquiz.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionPayloadFactory {

    TECHNICAL_ERROR(0, HttpStatus.INTERNAL_SERVER_ERROR, "technical.error"),
    INVALID_PAYLOAD(1, HttpStatus.BAD_REQUEST, "invalid.request.payload"),
    ATTENDEE_NOT_FOUND(2,  HttpStatus.BAD_REQUEST, "attendee.not.found"),
    SENIORITY_LEVEL_NOT_FOUND(3,  HttpStatus.BAD_REQUEST, "seniority.level.not.found");

    private final Integer code;
    private final HttpStatus status;
    private final String message;

    public ExceptionPayload get() {
        return new ExceptionPayload(code, status, message);
    }

}
