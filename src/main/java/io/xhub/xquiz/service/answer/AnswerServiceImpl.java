package io.xhub.xquiz.service.answer;

import io.xhub.xquiz.command.UpdateQuizInstanceDetailsCommand;
import io.xhub.xquiz.domain.Answer;
import io.xhub.xquiz.domain.Question;
import io.xhub.xquiz.domain.QuizInstance;
import io.xhub.xquiz.domain.QuizInstanceDetails;
import io.xhub.xquiz.dto.PassMarkDTO;
import io.xhub.xquiz.dto.QuestionDTO;
import io.xhub.xquiz.dto.mapper.QuizInstanceDetailMapper;
import io.xhub.xquiz.enums.Status;
import io.xhub.xquiz.repository.AnswerRepository;
import io.xhub.xquiz.repository.QuizInstanceDetailRepository;
import io.xhub.xquiz.repository.QuizInstructionRepository;
import io.xhub.xquiz.service.questionAnswerDetails.QuestionAnswerDetailsService;
import io.xhub.xquiz.service.quizInstanceDetails.QuizInstanceDetailsService;
import io.xhub.xquiz.service.quizinstance.QuizInstanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final QuizInstanceDetailsService quizInstanceDetailsService;
    private final QuizInstanceDetailRepository quizInstanceDetailRepository;
    private final QuestionAnswerDetailsService questionAnswerDetailsService;
    private final QuizInstanceService quizInstanceService;
    private final QuizInstanceDetailMapper quizInstanceDetailMapper;
    private final QuizInstructionRepository quizInstructionRepository;

    public QuestionDTO answer(String quizInstanceId, UpdateQuizInstanceDetailsCommand command) {
        command.validate();
        final List<Answer> answers = getAnswersByIds(command.getAnswersId());
        final Question question = answers.get(0).getQuestion();
        final QuizInstanceDetails quizInstanceDetails = quizInstanceDetailsService
                .getQuizInstanceDetails(quizInstanceId, question.getId());
        if (answerVerification(answers, question)) {
            quizInstanceDetails.setScore(quizInstanceDetails.getScore() + question.getScore());
        }
        quizInstanceService.updateLastQuestionIndexAndFinalScore(quizInstanceId, quizInstanceDetails);

        quizInstanceDetailRepository.save(quizInstanceDetails);
        log.info("quizInstanceDetails updated successfully");
        createQuestionAnswerDetails(answers, quizInstanceDetails);

        final Integer totalQuestions = Integer.valueOf(quizInstructionRepository.findQuizInstructionByKey("TOTAL_QUESTIONS").getValue());

        if (quizInstanceDetails.getQuestionIndex().equals(totalQuestions)) {
            QuizInstance quizInstance = quizInstanceService.findById(quizInstanceId);
            quizInstance.setStatus(Status.FINISHED);
            quizInstance.setEndDate(LocalDateTime.now());
            return null;
        }
        QuizInstanceDetails nextQuizInstanceDetails = quizInstanceDetailsService.getQuizInstanceDetailsByQuestionIndex(quizInstanceId, quizInstanceDetails.getQuestionIndex() + 1);
        return quizInstanceDetailMapper.toQuizInstanceDetailsDTO(nextQuizInstanceDetails).getQuestion();
    }

    private Boolean answerVerification(List<Answer> answers, Question question) {
        Integer totalCorrectAnswers = answerRepository.countCorrectAnswers(question.getId());
        if (totalCorrectAnswers.equals(answers.size())) {
            return answers.stream().allMatch(a -> Boolean.TRUE.equals(a.getIsCorrect()));
        }
        return Boolean.FALSE;
    }

    private void createQuestionAnswerDetails(List<Answer> answers, QuizInstanceDetails quizInstanceDetails) {
        answers.forEach(answer -> questionAnswerDetailsService.create(answer, quizInstanceDetails));
    }

    private List<Answer> getAnswersByIds(List<String> ids) {
        log.info("Begin fetching answers");
        return answerRepository.findAnswersByIdAndDeletedFalse(ids);
    }

    public PassMarkDTO finishQuiz(String quizInstanceId) {
        final Integer perfectScore = quizInstanceDetailRepository.sumQuestionsScoreByQuizInstanceId(quizInstanceId);
        final Integer scorePercentage = quizInstanceService.findById(quizInstanceId).getFinalScore();
        final Integer passMark = Integer.valueOf(quizInstructionRepository.findQuizInstructionByKey("PASS_TASK").getValue());
        float attendeeMark = (Float.valueOf(scorePercentage) * 100 / Float.valueOf(perfectScore));
        return PassMarkDTO.create(passMark, attendeeMark);
    }

}
