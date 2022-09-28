package io.xhub.xquiz.service.question;

import io.xhub.xquiz.command.QuizInstanceDetailsCommand;
import io.xhub.xquiz.domain.Question;
import io.xhub.xquiz.domain.SubTheme;
import io.xhub.xquiz.exception.BusinessException;
import io.xhub.xquiz.exception.ExceptionPayloadFactory;
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
        return questionRepository.findById(id).orElseThrow(
                () -> new BusinessException(ExceptionPayloadFactory.QUESTIONS_NOT_FOUND.get())
        );
    }

    @Override
    public List<Question> findQuestionsByPercentage(QuizInstanceDetailsCommand command, Integer totalQuestions) {
        log.info("Begin fetching sub theme with theme id {}", command.getThemeId());
        final List<SubTheme> subThemes = subThemeRepository.findAllByThemeId(command.getThemeId());
        log.info("Sub theme with size {} fetched successfully", subThemes.size());

        if(subThemes.size() > 1){
            final Map<String, List<Question>> map = new HashMap<>();

            subThemes.forEach(subTheme -> map.put(
                    subTheme.getId(), questionRepository.findListQuestionBySeniorityLevelIdAndSubThemeId(
                            command.getSeniorityLevelId(),
                            subTheme.getId(),
                            subTheme.getPercentage() * totalQuestions /100
                    )));
            return map.values().stream().flatMap(List::stream).collect(Collectors.toList());
        }else{
            return questionRepository.findListQuestionBySeniorityLevelIdAndSubThemeId(
                    command.getSeniorityLevelId(),
                    subThemes.get(0).getId(),
                    subThemes.get(0).getPercentage() * totalQuestions /100
            );
        }
    }
}
