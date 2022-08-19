package io.xhub.xquiz.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "question_answer_details")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionAnswerDetails {

    @EmbeddedId
    private QuestionAnswerDetailsId id;

    public static QuestionAnswerDetails create(final Answer answer, final QuizInstanceDetails questionDetails) {
        final QuestionAnswerDetails questionAnswerDetails = new QuestionAnswerDetails();
        final QuestionAnswerDetailsId questionAnswerDetailsId = new QuestionAnswerDetailsId();

        questionAnswerDetailsId.setAnswer(answer);
        questionAnswerDetailsId.setQuestionDetails(questionDetails);
        questionAnswerDetails.id = questionAnswerDetailsId;

        return questionAnswerDetails;
    }
}
