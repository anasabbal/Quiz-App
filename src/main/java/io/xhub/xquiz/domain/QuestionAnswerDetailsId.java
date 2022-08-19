package io.xhub.xquiz.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
@Embeddable
@Setter
@Getter
public class QuestionAnswerDetailsId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "question_details_id")
    private QuizInstanceDetails questionDetails;
}
