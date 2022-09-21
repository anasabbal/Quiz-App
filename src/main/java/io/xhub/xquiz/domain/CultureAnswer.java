package io.xhub.xquiz.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "CULTURE_ANSWERS")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CultureAnswer extends BaseEntity{

    @Column(name = "CONTENT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "culture_question_id")
    private CultureQuestion cultureQuestion;

    public static CultureAnswer create(String content, CultureQuestion question) {
        CultureAnswer cultureAnswer = new CultureAnswer();

        cultureAnswer.content = content;
        cultureAnswer.cultureQuestion = question;

        return cultureAnswer;
    }
}
