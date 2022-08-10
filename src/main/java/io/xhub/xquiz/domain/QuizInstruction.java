package io.xhub.xquiz.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "QUIZ_INSTRUCTIONS")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class QuizInstruction extends BaseEntity{

    @Column(name = "LABEL")
    private String label;

    @Column(name = "VALUE")
    private String value;
}
