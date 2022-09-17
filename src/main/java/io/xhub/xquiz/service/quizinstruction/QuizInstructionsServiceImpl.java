package io.xhub.xquiz.service.quizinstruction;

import io.xhub.xquiz.domain.QuizInstruction;
import io.xhub.xquiz.exception.BusinessException;
import io.xhub.xquiz.exception.ExceptionPayloadFactory;
import io.xhub.xquiz.repository.QuizInstructionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class QuizInstructionsServiceImpl implements QuizInstructionsService {
    private final QuizInstructionRepository quizInstructionRepository;

    @Override
    public List<QuizInstruction> findAllQuizInstruction() {
        return quizInstructionRepository.findAllQuizInstructionByDeletedFalse();
    }

    @Override
    public QuizInstruction findQuizInstructionByKey(final String key) {
        return quizInstructionRepository.findQuizInstructionByKey(key).orElseThrow(
                () -> new BusinessException(ExceptionPayloadFactory.QUIZ_INSTRUCTIONS_NOT_FOUND.get())
        );
    }
}
