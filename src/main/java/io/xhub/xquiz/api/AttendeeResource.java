package io.xhub.xquiz.api;

import io.xhub.xquiz.command.AttendeeCommand;
import io.xhub.xquiz.service.attendee.AttendeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.xhub.xquiz.constants.ResourcePath.*;

@RestController
@RequestMapping(V1 + ATTENDEES)
@RequiredArgsConstructor
public class AttendeeResource {

    private final AttendeeService attendeeService;

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody final AttendeeCommand attendeeCommand) {
        attendeeService.create(attendeeCommand);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
