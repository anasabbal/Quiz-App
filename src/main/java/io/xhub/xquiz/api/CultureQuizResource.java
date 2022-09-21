package io.xhub.xquiz.api;


import io.xhub.xquiz.command.CultureAnswerCommand;
import io.xhub.xquiz.dto.CultureQuestionDTO;
import io.xhub.xquiz.dto.mapper.CultureQuestionMapper;
import io.xhub.xquiz.service.CultureQuestion.CultureQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static io.xhub.xquiz.constants.ResourcePath.CULTURE_QUIZ;
import static io.xhub.xquiz.constants.ResourcePath.V1;

@RestController
@RequestMapping(V1 + CULTURE_QUIZ)
@RequiredArgsConstructor
public class CultureQuizResource {

    private final CultureQuestionService cultureQuestionService;
    private final CultureQuestionMapper cultureQuestionMapper;

    @GetMapping("/{quizInstanceId}")
    public ResponseEntity<List<CultureQuestionDTO>> getAllCultureQuestions(@PathVariable final String quizInstanceId) {
        return ResponseEntity.ok(cultureQuestionService.getAllQuestions(quizInstanceId).stream()
                                        .map(cultureQuestionMapper::toCultureQuestionDTO).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Void> answer(@RequestBody final CultureAnswerCommand command) {
        cultureQuestionService.answer(command);
        return ResponseEntity.ok().build();
    }
}
