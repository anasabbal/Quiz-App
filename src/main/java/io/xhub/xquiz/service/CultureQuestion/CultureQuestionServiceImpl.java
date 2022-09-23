package io.xhub.xquiz.service.CultureQuestion;

import io.xhub.xquiz.command.CultureAnswerCommand;
import io.xhub.xquiz.command.CultureAnswerDetailsCommand;
import io.xhub.xquiz.domain.*;
import io.xhub.xquiz.enums.CultureQuestionType;
import io.xhub.xquiz.exception.BusinessException;
import io.xhub.xquiz.exception.ExceptionPayloadFactory;
import io.xhub.xquiz.repository.CultureAnswerDetailsRepository;
import io.xhub.xquiz.repository.CultureAnswerRepository;
import io.xhub.xquiz.repository.CultureQuestionRepository;
import io.xhub.xquiz.repository.CultureQuizDetailsRepository;
import io.xhub.xquiz.service.quizinstance.QuizInstanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class CultureQuestionServiceImpl implements CultureQuestionService{

    private final CultureQuizDetailsRepository cultureQuizDetailsRepository;
    private final CultureQuestionRepository cultureQuestionRepository;
    private final CultureAnswerRepository cultureAnswerRepository;
    private final QuizInstanceService quizInstanceService;
    private final CultureAnswerDetailsRepository cultureAnswerDetailsRepository;

    @Override
    public List<CultureQuestion> getAllQuestions(String quizInstanceId) {
        getSessionAndCheckIfQuizPassed(quizInstanceId);
        return cultureQuestionRepository.findAllByDeletedFalse();
    }

    @Override
    public void answer(final CultureAnswerCommand command) {

        final QuizInstance quizInstance = getSessionAndCheckIfQuizPassed(command.getQuizInstanceId());

        CultureQuizDetails cultureQuizDetails = CultureQuizDetails.create(quizInstance);
        double sum = cultureQuestionRepository.sumCultureQuestionsScore();
        command.getAnswers().forEach(
                answer -> {
                    CultureQuestion question = getQuestionById(answer);
                    if (question.getType().equals(CultureQuestionType.TEXT)) {
                        answerQuestion(answer, question, cultureQuizDetails);
                    } else {
                        answerQuestion(answer, cultureQuizDetails);
                    }
                    cultureQuizDetails.addQuestionAndScore(question);
                    cultureQuizDetails.updatePercentFinalScore(sum);
                }
        );
        cultureQuizDetailsRepository.save(cultureQuizDetails);
    }

    private void answerQuestion(CultureAnswerDetailsCommand cultureAnswerCommand, CultureQuizDetails cultureQuizDetails) {
        cultureAnswerCommand.getAnswersId().forEach(
                id -> createCultureAnswersDetails(getAnswerById(id), cultureQuizDetails)
        );
    }

    private void answerQuestion(CultureAnswerDetailsCommand answerDetailsCommand, CultureQuestion question, CultureQuizDetails cultureQuizDetails) {
        final CultureAnswer answer = cultureAnswerRepository.save(CultureAnswer.create(answerDetailsCommand.getContent(), question));
        createCultureAnswersDetails(answer,cultureQuizDetails);
    }

    private void createCultureAnswersDetails(CultureAnswer answer, CultureQuizDetails cultureQuizDetails) {
        final CultureAnswerDetails cultureAnswerDetails = CultureAnswerDetails.create(answer, cultureQuizDetails);
        cultureAnswerDetailsRepository.save(cultureAnswerDetails);
    }

    private CultureAnswer getAnswerById(String answerId) {
        return cultureAnswerRepository.findById(answerId).orElseThrow(
                () -> new BusinessException(ExceptionPayloadFactory.ANSWER_NOT_FOUND.get())
        );
    }

    private CultureQuestion getQuestionById(CultureAnswerDetailsCommand answer) {
        return cultureQuestionRepository.findById(answer.getQuestionId()).orElseThrow(
                () -> new BusinessException(ExceptionPayloadFactory.QUESTIONS_NOT_FOUND.get())
        );
    }

    private QuizInstance getSessionAndCheckIfQuizPassed(final String quizInstanceId) {
        final QuizInstance quizInstance = quizInstanceService.findById(quizInstanceId);
        log.info("quiz instance with id {} fetched successfully", quizInstance.getId());

        log.info("Begin searching if the attendee with quiz instance id {} has already passed the culture quiz", quizInstanceId);
        Boolean quizPassed = cultureQuizDetailsRepository.existsByQuizInstanceIdAndDeletedFalse(quizInstanceId);

        if (Boolean.TRUE.equals(quizPassed)) {
            log.error("The attendee with quiz instance id {} has already passed the culture quiz", quizInstanceId);
            throw new BusinessException(ExceptionPayloadFactory.ATTENDEE_ALREADY_PASSED_CULTURE_QUIZ.get());
        }
        return quizInstance;
    }
}
