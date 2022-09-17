package io.xhub.xquiz.service.quizInstanceDetails;

import io.xhub.xquiz.domain.QuizInstanceDetails;
import io.xhub.xquiz.exception.BusinessException;
import io.xhub.xquiz.exception.ExceptionPayloadFactory;
import io.xhub.xquiz.repository.QuizInstanceDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuizInstanceDetailsServiceImpl implements QuizInstanceDetailsService {
    private final QuizInstanceDetailRepository quizInstanceDetailRepository;

    @Override
    public QuizInstanceDetails getQuizInstanceDetails(String quizInstanceId, String questionId) {
        log.info("Begin fetching quizInstanceDetails with id {}", quizInstanceId);
        return quizInstanceDetailRepository.findQuizInstanceDetails(quizInstanceId, questionId).orElseThrow(
                () -> new BusinessException(ExceptionPayloadFactory.QUIZ_INSTANCE_DETAILS_NOT_FOUND.get())
        );
    }

    @Override
    public QuizInstanceDetails getQuizInstanceDetailsByQuestionIndex(String quizInstanceId, Integer questionIndex) {
        return quizInstanceDetailRepository.findQuizInstanceDetailsByQuizInstanceIdAndQuestionIndex(quizInstanceId, questionIndex);
    }

    @Override
    public QuizInstanceDetails findQuizInstanceDetailsByQuizInstanceAndQuestionIndex(final String id, final Integer index) {
        return quizInstanceDetailRepository.
                findQuizInstanceDetailsByQuizInstanceIdAndQuestionIndex(id, index);
    }

    @Override
    public void save(final QuizInstanceDetails quizInstanceDetails) {
        quizInstanceDetailRepository.save(quizInstanceDetails);
    }

    @Override
    public Boolean checkIfSessionQuestionsExist(final String sessionId) {
        return quizInstanceDetailRepository.existsByQuizInstanceId(sessionId);
    }

    @Override
    public Integer sumQuestionScore(final String id) {
        return quizInstanceDetailRepository.sumQuestionsScoreByQuizInstanceId(id);
    }
}
