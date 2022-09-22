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

import java.util.ArrayList;
import java.util.List;
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

        final List<List<Question>> questions = new ArrayList<>();

        subThemes.forEach(subTheme -> log.info("Begin creating list of question from sub theme id {} and percentage ", subTheme.getId(), subTheme.getPercentage()));
        subThemes.forEach(subTheme -> questions.add(questionRepository.findListQuestionBySeniorityLevelIdAndSubThemeId(command.getSeniorityLevelId(), subTheme.getId(), subTheme.getPercentage() * totalQuestions /100)));
        subThemes.forEach(subTheme -> log.info("List of question created successfully for sub theme id {} and percentage ", subTheme.getId(), subTheme.getPercentage()));
        log.info("Question with size {} created successfully", questions.size());
       return questions.stream()
               .flatMap(List::stream)
               .collect(Collectors.toList());
    }
}
