package io.xhub.xquiz.service.answer;

import io.xhub.xquiz.command.UpdateQuizInstanceDetailsCommand;
import io.xhub.xquiz.domain.Answer;
import io.xhub.xquiz.domain.Question;
import io.xhub.xquiz.domain.QuizInstanceDetails;
import io.xhub.xquiz.repository.AnswerRepository;
import io.xhub.xquiz.service.question.QuestionService;
import io.xhub.xquiz.service.questionAnswerDetails.QuestionAnswerDetailsService;
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
    private final QuestionService questionService;
    private final AnswerRepository answerRepository;
    private final QuestionAnswerDetailsService questionAnswerDetailsService;

    public Question getQuestion(final UpdateQuizInstanceDetailsCommand command,final List<Answer> answers) {
        if (command.getQuestionId() != null)
            return questionService.getById(command.getQuestionId());
        return answers.get(0).getQuestion();
    }

    public Boolean answerVerification(List<Answer> answers, Question question) {
        log.info("Begin count total correct answers with question id {}", question.getId());
        Integer totalCorrectAnswers = answerRepository.countCorrectAnswers(question.getId());

        if (totalCorrectAnswers.equals(answers.size())) {
            return answers.stream().allMatch(a -> Boolean.TRUE.equals(a.getIsCorrect()));
        }
        return Boolean.FALSE;
    }

    public void createQuestionAnswerDetails(List<Answer> answers, QuizInstanceDetails quizInstanceDetails) {
        answers.forEach(answer -> questionAnswerDetailsService.create(answer, quizInstanceDetails));
    }

    public List<Answer> getAnswersByIds(List<String> ids) {
        log.info("Begin fetching answers");
        return answerRepository.findAnswersByIdAndDeletedFalse(ids);
    }

    @Override
    public Integer countCorrectAnswers(String id) {
        return answerRepository.countCorrectAnswers(id);
    }
}
