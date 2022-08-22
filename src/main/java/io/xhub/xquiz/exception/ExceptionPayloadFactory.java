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
    EVENT_NOT_FOUND(4, HttpStatus.NOT_FOUND, "events.not.found"),
    EVENT_SETUP_NOT_FOUND(5, HttpStatus.NOT_FOUND, "events.setup.not.found"),
    FILE_NOT_FOUND(6, HttpStatus.NOT_FOUND, "file.not.found"),
    ATTENDEE_ALREADY_EXISTS(7, HttpStatus.BAD_REQUEST, "attendee.already.exists"),
    ATTENDEE_RESPONSE_NOT_OK(8,HttpStatus.INTERNAL_SERVER_ERROR,"internal.server.error"),
    ATTENDEE_EVENT_ALREADY_EXISTS(9, HttpStatus.FORBIDDEN, "attendee.event.already.exists"),
    HTTP_SUBMIT_METHOD_NOT_SUPPORTED(10, HttpStatus.METHOD_NOT_ALLOWED,"http.method.not.supported"),
    QUIZ_INSTANCE_NOT_FOUND(11, HttpStatus.NOT_FOUND, "quiz.instance.not.found"),
    THEME_NOT_FOUND(12, HttpStatus.NOT_FOUND, "theme.not.found"),
    QUIZ_INSTANCE_CLOSED(13, HttpStatus.FORBIDDEN,"quiz.instance.closed"),
    QUIZ_INSTANCE_DETAILS_NOT_FOUND(14,HttpStatus.NOT_FOUND,"quiz.instance.details.not.found"),
    REGISTRATION_CODE_NOT_FOUND(15,HttpStatus.NOT_FOUND,"registration.code.not.found");


    private final Integer code;
    private final HttpStatus status;
    private final String message;

    public ExceptionPayload get() {
        return new ExceptionPayload(code, status, message);
    }

}
