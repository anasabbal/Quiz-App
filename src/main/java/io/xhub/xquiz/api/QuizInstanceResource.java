package io.xhub.xquiz.api;

import io.xhub.xquiz.command.CreateEventSessionCommand;
import io.xhub.xquiz.dto.QuizInstanceDTO;
import io.xhub.xquiz.dto.mapper.QuizInstanceMapper;
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

    @PostMapping
    public ResponseEntity<QuizInstanceDTO> create(@RequestBody final CreateEventSessionCommand body) {
        return ResponseEntity.ok(quizInstanceMapper.toQuizInstanceDTO(quizInstanceService.createSession(body)));
    }

    @PatchMapping("/{quizInstanceId}" +LOGOUT)
    public ResponseEntity<Void> updateStatus(@PathVariable("quizInstanceId") String quizInstanceId){

        quizInstanceService.updateStatus(quizInstanceId);
        return ResponseEntity.ok().build();
    }
}
