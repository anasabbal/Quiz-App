package io.xhub.xquiz.domain;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "QUESTIONS")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Question extends BaseEntity{


    @Column(name = "SCORE")
    private int score;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "IS_MULTIPLE_CHOICE")
    private Boolean isMultipleChoice;

    @ManyToOne
    private SeniorityLevel seniorityLevel;

    @ManyToOne
    private SubTheme subTheme;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers;
}
