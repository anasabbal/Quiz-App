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
    ATTENDEE_RESPONSE_NOT_OK(8, HttpStatus.INTERNAL_SERVER_ERROR, "internal.server.error"),
    ATTENDEE_EVENT_ALREADY_EXISTS(9, HttpStatus.FORBIDDEN, "attendee.event.already.exists"),
    HTTP_SUBMIT_METHOD_NOT_SUPPORTED(10, HttpStatus.METHOD_NOT_ALLOWED, "http.method.not.supported"),
    QUIZ_INSTANCE_NOT_FOUND(11, HttpStatus.NOT_FOUND, "quiz.instance.not.found"),
    QUIZ_INSTANCE_CLOSED(13, HttpStatus.FORBIDDEN, "quiz.instance.closed"),
    QUIZ_INSTANCE_DETAILS_NOT_FOUND(14, HttpStatus.NOT_FOUND, "quiz.instance.details.not.found"),
    REGISTRATION_CODE_NOT_FOUND(15, HttpStatus.NOT_FOUND, "registration.code.not.found"),
    QUESTION_ALREADY_ANSWERED(16, HttpStatus.BAD_REQUEST, "question.already.answered"),
    QUIZ_INSTRUCTIONS_NOT_FOUND(17, HttpStatus.NOT_FOUND, "quiz.instructions.not.found"),
    QUESTIONS_NOT_FOUND(19, HttpStatus.NOT_FOUND, "questions.not.found"),
    INVALID_RATING_PAYLOAD(20, HttpStatus.BAD_REQUEST, "invalid.rating.payload"),
    QUIZ_INSTANCE_FINISHED(21, HttpStatus.FORBIDDEN, "quiz.instance.finished"),
    GOODIES_OUT_OF_STOCK(27, HttpStatus.BAD_REQUEST, "goodies.out.of.stock"),
    QUIZ_EVENT_PARTICIPANT_NOT_FOUND(18, HttpStatus.NOT_FOUND, "quiz.participant.not.found"),
    MISSING_REQUEST_BODY_ERROR_CODE(26, HttpStatus.BAD_REQUEST, "request.missing.body"),
    GOODY_NOT_FOUND(25, HttpStatus.NOT_FOUND, "goody.not.found"),
    PARTICIPANT_IS_NOT_ELIGIBLE_FOR_GOODY(23, HttpStatus.BAD_REQUEST, "participant.not.eligible.for.goody"),
    PARTICIPANT_ALREADY_RECEIVED_GOODY(24, HttpStatus.BAD_REQUEST, "participant.already.received.goody"),
    INVALID_FORM_REGISTRATION_PAYLOAD(22, HttpStatus.BAD_REQUEST, "invalid.form.registration");


    private final Integer code;
    private final HttpStatus status;
    private final String message;

    public ExceptionPayload get() {
        return new ExceptionPayload(code, status, message);
    }

}
