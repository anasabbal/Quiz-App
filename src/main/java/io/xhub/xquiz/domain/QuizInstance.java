package io.xhub.xquiz.domain;

import io.xhub.xquiz.enums.Status;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
@Table(name = "QUIZ_INSTANCE")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class QuizInstance extends BaseEntity{
    @Column(name = "START_DATE")
    private LocalDateTime startDate;
    @Column(name = "END_DATE")
    private LocalDateTime endDate;
    @Column(name = "STATUS")
    private Status status;
    @Column(name = "FINAL_SCORE")
    private int finalScore;
    @Column(name = "LAST_QUESTION_INDEX")
    private int lastQuestionIndex;
    @OneToOne(cascade = CascadeType.PERSIST)
    private AttendeeEvent attendeeEvent;


    public static QuizInstance create(AttendeeEvent attendeeEvent) {
        QuizInstance quizInstance = new QuizInstance();
        quizInstance.attendeeEvent = attendeeEvent;
        quizInstance.status = Status.OPENED;
        quizInstance.startDate = LocalDateTime.now();
        return quizInstance;
    }
    public Status getCurrentStatus(){
        return status;
    }
    public void updateStatusToClosed(){
        this.status = Status.CLOSED;
    }
}