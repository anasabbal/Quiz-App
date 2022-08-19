package io.xhub.xquiz.service.questionAnswerDetails;

import io.xhub.xquiz.domain.Answer;
import io.xhub.xquiz.domain.QuestionAnswerDetails;
import io.xhub.xquiz.domain.QuizInstanceDetails;
import io.xhub.xquiz.repository.QuestionAnswerDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionAnswerDetailsServiceImpl implements QuestionAnswerDetailsService {
    private final QuestionAnswerDetailsRepository questionAnswerDetailsRepository;

    public QuestionAnswerDetails create(final Answer answer, final QuizInstanceDetails questionDetails) {
        return questionAnswerDetailsRepository.save(QuestionAnswerDetails.create(answer, questionDetails));
    }

}
