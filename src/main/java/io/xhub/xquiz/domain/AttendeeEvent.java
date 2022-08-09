package io.xhub.xquiz.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Table(name = "ATTENDEE_EVENT")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AttendeeEvent{
    @EmbeddedId
    private AttendeeEventId id;

    public static AttendeeEvent create(final Attendee attendee, final Event event) {
        final AttendeeEvent attendeeEvent = new AttendeeEvent();
        final AttendeeEventId attendeeEventId = new AttendeeEventId();

        attendeeEventId.setAttendee(attendee);
        attendeeEventId.setEvent(event);
        attendeeEvent.id = attendeeEventId;

        return attendeeEvent;
    }
}
