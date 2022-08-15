package io.xhub.xquiz.domain;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "QUIZ_INSTANCE_DETAILS")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class QuizInstanceDetails extends BaseEntity{

    @Column(name = "SCORE")
    private int score;

    @Column(name = "QUESTION_INDEX")
    private int questionIndex;
    @OneToMany
    private List<Question> questions;
    @OneToOne
    private QuizInstance quizInstance;


    public static QuizInstanceDetails create(List<Question> questions,
                                             QuizInstance quizInstance) {
        final QuizInstanceDetails quizInstanceDetails = new QuizInstanceDetails();

        quizInstanceDetails.questions = questions;
        quizInstanceDetails.quizInstance = quizInstance;
        return quizInstanceDetails;
    }
}
