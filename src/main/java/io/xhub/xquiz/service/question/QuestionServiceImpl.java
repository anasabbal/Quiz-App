package io.xhub.xquiz.service.question;

import io.xhub.xquiz.command.QuizInstanceDetailsCommand;
import io.xhub.xquiz.domain.Question;
import io.xhub.xquiz.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    @Override
    public List<Question> findListQuestionBySeniorityLevelIdAndSubThemeId(QuizInstanceDetailsCommand command, Integer totalQuestions) {
        return questionRepository.findListQuestionBySeniorityLevelIdAndSubThemeId(
                command.getSeniorityLevelId(), command.getSubThemeId(), totalQuestions);
    }

    @Override
    public Question getById(String id) {
        return questionRepository.findById(id).get();
    }
}
