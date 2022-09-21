package io.xhub.xquiz.domain;

import io.xhub.xquiz.enums.CultureQuestionType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "CULTURE_QUESTIONS")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CultureQuestion extends BaseEntity {

    @Column(name = "SCORE")
    private float score;

    @Column(name = "CONTENT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private CultureQuestionType type;

    @OneToMany(mappedBy = "cultureQuestion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CultureAnswer> cultureAnswers;
}
