package io.xhub.xquiz.api;

import io.xhub.xquiz.command.CreateEventSessionCommand;
import io.xhub.xquiz.command.QuizInstanceDetailsCommand;
import io.xhub.xquiz.dto.QuizInstanceDTO;
import io.xhub.xquiz.dto.QuizInstanceDetailsDTO;
import io.xhub.xquiz.dto.mapper.QuizInstanceMapper;
import io.xhub.xquiz.service.quizinstance.QuizInstanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;

import static io.xhub.xquiz.constants.ResourcePath.*;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

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

    @PostMapping(START_QUIZ)
    public ResponseEntity<QuizInstanceDetailsDTO> startQuiz(@RequestBody QuizInstanceDetailsCommand quizInstanceDetailsCommand){
        final QuizInstanceDetailsDTO quizInstanceDetails = quizInstanceService.startQuiz(quizInstanceDetailsCommand);
        final URI uri = fromCurrentRequest().path("/{id}").buildAndExpand(quizInstanceDetails.getId()).toUri();
        return ResponseEntity.created(uri).body(quizInstanceDetails);
    }
}
