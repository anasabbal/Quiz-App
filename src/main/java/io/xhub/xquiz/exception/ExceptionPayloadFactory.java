package io.xhub.xquiz.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionPayloadFactory {

    TECHNICAL_ERROR(0, HttpStatus.INTERNAL_SERVER_ERROR, "technical.error");

    private final Integer code;
    private final HttpStatus status;
    private final String message;

    public ExceptionPayload get() {
        return new ExceptionPayload(code, status, message);
    }

}
