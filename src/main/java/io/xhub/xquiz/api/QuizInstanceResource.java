package io.xhub.xquiz.api;


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


    @PatchMapping("/{quizInstanceId}" +LOGOUT)
    public ResponseEntity<Void> updateStatus(@PathVariable("quizInstanceId") String quizInstanceId){

        quizInstanceService.updateStatus(quizInstanceId);
        return ResponseEntity.ok().build();
    }
}