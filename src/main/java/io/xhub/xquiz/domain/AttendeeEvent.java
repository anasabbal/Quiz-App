package io.xhub.xquiz.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.function.IntSupplier;

@Table(name = "ATTENDEE_EVENT")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AttendeeEvent {

    @EmbeddedId
    private AttendeeEventId id;
    @ManyToOne
    private Goody goody;

    @OneToOne(cascade = CascadeType.ALL)
    private Feedback feedBack;


    public static AttendeeEvent create(final Attendee attendee, final Event event) {
        final AttendeeEvent attendeeEvent = new AttendeeEvent();
        final AttendeeEventId attendeeEventId = new AttendeeEventId();

        attendeeEventId.setAttendee(attendee);
        attendeeEventId.setEvent(event);
        attendeeEvent.id = attendeeEventId;

        return attendeeEvent;
    }

    public void giftGoody(Goody goody) {
        if (this.goody == null) {
            goody.decrementStock();
        }
        else if (!this.goody.equals(goody)) {
            this.goody.incrementStock();
            goody.decrementStock();
        }
        this.goody = goody;
    }


    public boolean isEligibleForGoody(Goody goody, IntSupplier techQuizScoreInPercent, IntSupplier culturalQuizScoreInPercent, float techQuizFactor, float cultQuizFactor) {
        return (techQuizScoreInPercent.getAsInt() * techQuizFactor / 100) + (culturalQuizScoreInPercent.getAsInt() * cultQuizFactor / 100) >= goody.getWinScoreThreshold();
    }

    public void submitInterviewFeedback(String content) {
        if (this.feedBack == null)
            this.feedBack = Feedback.create(content);

        this.feedBack.update(content);
    }
}
