package io.xhub.xquiz.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "FEEDBACKS")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Feedback extends BaseEntity {

    @Column(name = "CONTENT")
    private String content;

    @OneToOne(mappedBy = "feedBack")
    private AttendeeEvent attendeeEvent;

    public static Feedback create(String content) {
        final Feedback feedBack = new Feedback();
        feedBack.content = content;

        return feedBack;
    }

    public void update(String content) {
        this.content = content;
    }
}
