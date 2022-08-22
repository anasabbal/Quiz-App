package io.xhub.xquiz.api;

import io.xhub.xquiz.command.CreateEventSessionCommand;
import io.xhub.xquiz.command.QuizInstanceDetailsCommand;
import io.xhub.xquiz.command.UpdateQuizInstanceDetailsCommand;
import io.xhub.xquiz.domain.Attendee;
import io.xhub.xquiz.dto.*;
import io.xhub.xquiz.dto.mapper.AttendeeMapper;
import io.xhub.xquiz.dto.mapper.QuizInstanceMapper;
import io.xhub.xquiz.service.answer.AnswerService;
import io.xhub.xquiz.service.quizinstance.QuizInstanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static io.xhub.xquiz.constants.ResourcePath.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(V1 + QUIZ_INSTANCE)
public class QuizInstanceResource {

    private final QuizInstanceService quizInstanceService;
    private final QuizInstanceMapper quizInstanceMapper;
    private final AnswerService answerService;
    private final AttendeeMapper attendeeMapper;

    @PostMapping
    public ResponseEntity<QuizInstanceDTO> create(@RequestBody final CreateEventSessionCommand body) {
        return ResponseEntity.ok(quizInstanceMapper.toQuizInstanceDTO(quizInstanceService.createSession(body)));
    }

    @PatchMapping("/{quizInstanceId}" + LOGOUT)
    public ResponseEntity<Void> updateStatus(@PathVariable("quizInstanceId") String quizInstanceId) {

        quizInstanceService.updateStatus(quizInstanceId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(START_QUIZ)
    public ResponseEntity<QuizDetailDTO> startQuiz(@RequestBody final QuizInstanceDetailsCommand quizInstanceDetailsCommand) {
        return ResponseEntity.ok(quizInstanceService.startQuiz(quizInstanceDetailsCommand));
    }

    @PatchMapping("/{quizInstanceId}" + ANSWER)
    public ResponseEntity<QuestionDTO> answer(@PathVariable("quizInstanceId") String quizInstanceId, @RequestBody UpdateQuizInstanceDetailsCommand command) {
        return ResponseEntity.ok(answerService.answer(quizInstanceId, command));
    }

    @GetMapping("{quizInstanceId}")
    public ResponseEntity<AttendeeDTO> getAttendee(@PathVariable final String quizInstanceId) {
        final Attendee attendee = quizInstanceService.getAttendeeByQuizInstanceId(quizInstanceId);
        return ResponseEntity.ok(attendeeMapper.toAttendeeDTO(attendee));
    }
}
