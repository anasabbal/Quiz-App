package io.xhub.xquiz.service.question;

import io.xhub.xquiz.command.QuizInstanceDetailsCommand;
import io.xhub.xquiz.domain.Question;
import io.xhub.xquiz.domain.SubTheme;
import io.xhub.xquiz.repository.QuestionRepository;
import io.xhub.xquiz.repository.SubThemeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final SubThemeRepository subThemeRepository;

    @Override
    public Question getById(String id) {
        return questionRepository.findById(id).get();
    }

    @Override
    public List<Question> findQuestionsByPercentage(QuizInstanceDetailsCommand command, Integer totalQuestions) {
        log.info("Begin fetching sub theme with theme id {}", command.getThemeId());
        final List<SubTheme> subThemes = subThemeRepository.findAllByThemeId(command.getThemeId());
        log.info("Sub theme with size {} fetched successfully");

        final Map<String, List<Question>> map = new HashMap<>();

        subThemes.forEach(subTheme -> log.info("Begin creating list of question from sub theme with id {} and percentage {}", subTheme.getId(), subTheme.getPercentage()));
        subThemes.forEach(subTheme -> map.put(
                subTheme.getId(), questionRepository.findListQuestionBySeniorityLevelIdAndSubThemeId(
                command.getSeniorityLevelId(),
                subTheme.getId(),
                subTheme.getPercentage() * totalQuestions /100
        )));
        subThemes.forEach(subTheme -> log.info("List of question created successfully for sub theme  with id {} and percentage {}", subTheme.getId(), subTheme.getPercentage()));

        List<Question> questions = map.values().stream().flatMap(List::stream).collect(Collectors.toList());
        log.info("Final questions with size {}", questions.size());
       return questions;
    }
}
