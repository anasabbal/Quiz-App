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
import io.xhub.xquiz.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
        final QuizInstance quizInstance = quizInstanceService.findById(quizInstanceId);
        log.info("Session with id {} fetched successfully", quizInstanceId);

        final List<Answer> answers = getAnswersByIds(command.getAnswersId().stream().distinct().collect(Collectors.toList()));
        log.info("Answers with size {} fetched successfully", answers.size());

        final Question question = answers.get(0).getQuestion();
        final QuizInstanceDetails quizInstanceDetails = quizInstanceDetailsService
                .getQuizInstanceDetails(quizInstanceId, question.getId());
        log.info("Quiz instance details with id {} fetched successfully", quizInstanceDetails.getId());

        if (answerVerification(answers, question)) {
            quizInstanceDetails.setScore(question.getScore());
        }

        quizInstanceService.updateLastQuestionIndexAndFinalScore(quizInstanceDetails, quizInstance);

        quizInstanceDetailRepository.save(quizInstanceDetails);
        log.info("quizInstanceDetails updated successfully");
        createQuestionAnswerDetails(answers, quizInstanceDetails);
log.info("Begin fetching total question");
        final Integer totalQuestions = Integer.valueOf(quizInstanceService.getQuizInstructionsByKey("TOTAL_QUESTIONS").getValue());

        if (quizInstanceDetails.getQuestionIndex().equals(totalQuestions)) {
            return null;
        }
        log.info("Begin fetching next quiz instance details with id {} and last question {}", quizInstanceId, quizInstance.getLastQuestionIndex() + 1);
        QuizInstanceDetails nextQuizInstanceDetails = quizInstanceDetailsService.getQuizInstanceDetailsByQuestionIndex(quizInstanceId, quizInstance.getLastQuestionIndex() + 1);
        QuestionDTO nextQuestion = quizInstanceDetailMapper.toQuizInstanceDetailsDTO(nextQuizInstanceDetails).getQuestion();
        nextQuestion.setTotalCorrectAnswers(answerRepository.countCorrectAnswers(nextQuestion.getId()));
        return nextQuestion;
    }

    private Boolean answerVerification(List<Answer> answers, Question question) {
        log.info("Begin count total correct answers with question id {}", question.getId());
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
        QuizInstance quizInstance = quizInstanceService.findById(quizInstanceId);
        quizInstance.setStatus(Status.FINISHED);
        quizInstance.setEndDate(LocalDateTime.now());
        log.info("Begin sum question score by quiz instance id {}", quizInstanceId);
        final Integer perfectScore = quizInstanceDetailRepository.sumQuestionsScoreByQuizInstanceId(quizInstanceId);
        final Integer scorePercentage = quizInstanceService.findById(quizInstanceId).getFinalScore();
        log.info("Begin fetching pass  mark from quiz instruction");
        final Integer passMark = Integer.valueOf(quizInstanceService.getQuizInstructionsByKey("PASS_TASK").getValue());
        float attendeeMark = (Float.valueOf(scorePercentage) * 100 / Float.valueOf(perfectScore));
        return PassMarkDTO.create(passMark, attendeeMark);
    }

}
