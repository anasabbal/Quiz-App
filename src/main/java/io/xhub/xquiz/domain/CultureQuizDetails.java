package io.xhub.xquiz.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "CULTURE_QUIZ_DETAILS")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CultureQuizDetails extends BaseEntity {

    @Column(name = "SCORE")
    private float score = 0;

    @ManyToMany
    private List<CultureQuestion> cultureQuestion;

    @OneToOne
    private QuizInstance quizInstance;


    public static CultureQuizDetails create(QuizInstance quizInstance) {
        CultureQuizDetails cultureQuizDetails = new CultureQuizDetails();

        cultureQuizDetails.cultureQuestion = new ArrayList<CultureQuestion>();
        cultureQuizDetails.quizInstance = quizInstance;

        return cultureQuizDetails;
    }

    public void addQuestionAndScore(CultureQuestion question) {
        this.cultureQuestion.add(question);
        this.score += question.getScore();
    }
}
