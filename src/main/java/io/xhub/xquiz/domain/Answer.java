package io.xhub.xquiz.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "answers")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Answer extends BaseEntity {

    @Column(name = "is_correct")
    private Boolean isCorrect;

    @Column(name = "CONTENT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
