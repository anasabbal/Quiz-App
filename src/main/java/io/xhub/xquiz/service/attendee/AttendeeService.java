package io.xhub.xquiz.service.attendee;

import io.xhub.xquiz.command.CreateEventSessionCommand;
import io.xhub.xquiz.domain.Attendee;
import io.xhub.xquiz.dto.ResponseAttendeeDTO;

public interface AttendeeService {
    Attendee getOrCreateAttendee(final CreateEventSessionCommand body);
    Attendee create(final ResponseAttendeeDTO body);
}
