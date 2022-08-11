package io.xhub.xquiz.service.attendeeevent;

import io.xhub.xquiz.domain.Attendee;
import io.xhub.xquiz.domain.AttendeeEvent;
import io.xhub.xquiz.domain.Event;

public interface AttendeeEventService {
    AttendeeEvent getOrCreateAttendeeEvent(final Attendee attendee, final Event event);
}
