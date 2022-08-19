package io.xhub.xquiz.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "QUIZ_INSTANCE_DETAILS")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class QuizInstanceDetails extends BaseEntity {

    @Column(name = "SCORE")
    private Integer score = 0;

    @Column(name = "QUESTION_INDEX")
    private Integer questionIndex;
    @ManyToOne
    private Question question;
    @ManyToOne
    private QuizInstance quizInstance;

    public static QuizInstanceDetails create(Question question, QuizInstance quizInstance, Integer questionIndex) {
        final QuizInstanceDetails quizInstanceDetails = new QuizInstanceDetails();

        quizInstanceDetails.question = question;
        quizInstanceDetails.quizInstance = quizInstance;
        quizInstanceDetails.questionIndex = questionIndex;

        return quizInstanceDetails;
    }

}
