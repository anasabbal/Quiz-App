package io.xhub.xquiz.service.attendee;

import io.xhub.xquiz.command.AttendeeCommand;

public interface AttendeeService {
    void create(AttendeeCommand attendeeCommand);
}
