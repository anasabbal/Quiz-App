package io.xhub.xquiz.service.answer;

import io.xhub.xquiz.command.UpdateQuizInstanceDetailsCommand;
import io.xhub.xquiz.domain.Answer;
import io.xhub.xquiz.domain.Question;
import io.xhub.xquiz.domain.QuizInstanceDetails;
import io.xhub.xquiz.dto.QuestionDTO;
import io.xhub.xquiz.dto.mapper.QuizInstanceDetailMapper;
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
        if (answerVerification(answers)) {
            quizInstanceDetails.setScore(quizInstanceDetails.getScore() + question.getScore());
        }
        quizInstanceService.updateLastQuestionIndex(quizInstanceId, quizInstanceDetails);
        quizInstanceDetailRepository.save(quizInstanceDetails);
        log.info("quizInstanceDetails updated successfully");
        createQuestionAnswerDetails(answers, quizInstanceDetails);

        final Integer totalQuestions = Integer.valueOf(quizInstructionRepository.findQuizInstructionByKey("TOTAL_QUESTIONS").getValue());

        if (quizInstanceDetails.getQuestionIndex().equals(totalQuestions)) {
            return null;
        }
        QuizInstanceDetails nextQuizInstanceDetails = quizInstanceDetailsService.getQuizInstanceDetailsByQuestionIndex(quizInstanceId, quizInstanceDetails.getQuestionIndex() + 1);
        return quizInstanceDetailMapper.toQuizInstanceDetailsDTO(nextQuizInstanceDetails).getQuestion();
    }

    private Boolean answerVerification(List<Answer> answers) {
        // FIXME
        return answers.stream().allMatch(a -> Boolean.TRUE.equals(a.getIsCorrect()));
    }

    private void createQuestionAnswerDetails(List<Answer> answers, QuizInstanceDetails quizInstanceDetails) {
        answers.forEach(answer -> questionAnswerDetailsService.create(answer, quizInstanceDetails));
    }

    private List<Answer> getAnswersByIds(List<String> ids) {
        log.info("Begin fetching answers");
        return answerRepository.findAnswersByIdAndDeletedFalse(ids);
    }


}
