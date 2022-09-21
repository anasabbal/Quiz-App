package io.xhub.xquiz.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "CULTURE_ANSWERS_DETAILS")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CultureAnswerDetails extends BaseEntity {

    @ManyToOne
    private CultureAnswer cultureAnswer;

    @ManyToOne
    private CultureQuizDetails cultureQuizDetails;

    @Column(name = "CONTENT")
    private String content;

    public static CultureAnswerDetails create(CultureAnswer answer, CultureQuizDetails cultureQuizDetails) {
        CultureAnswerDetails cultureAnswerDetails = new CultureAnswerDetails();

        cultureAnswerDetails.cultureQuizDetails = cultureQuizDetails;
        cultureAnswerDetails.cultureAnswer = answer;
        cultureAnswerDetails.content = answer.getContent();

        return cultureAnswerDetails;
    }
}
