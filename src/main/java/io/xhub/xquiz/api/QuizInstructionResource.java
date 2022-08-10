package io.xhub.xquiz.api;


import io.xhub.xquiz.dto.QuizInstructionDTO;
import io.xhub.xquiz.service.quizinstance.QuizInstanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static io.xhub.xquiz.constants.ResourcePath.QUIZ_INSTRUCTION;
import static io.xhub.xquiz.constants.ResourcePath.V1;

@RestController
@RequestMapping(V1 + QUIZ_INSTRUCTION)
@RequiredArgsConstructor
public class QuizInstructionResource {

    private final QuizInstanceService quizInstanceService;


    @GetMapping
    public ResponseEntity<List<QuizInstructionDTO>> getQuizInstructions(){
        return ResponseEntity.ok(quizInstanceService.getQuizInstructions());
    }
}
