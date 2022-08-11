package io.xhub.xquiz.domain;

import io.xhub.xquiz.command.AttendeeCommand;
import io.xhub.xquiz.dto.ResponseAttendeeDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "attendees")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Attendee extends BaseEntity {

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    public static Attendee create(final AttendeeCommand attendeeCommand) {
        final Attendee attendee = new Attendee();

        attendee.firstName = attendeeCommand.getFirstName();
        attendee.lastName = attendeeCommand.getLastName();
        attendee.email = attendeeCommand.getEmail();
        attendee.phoneNumber = attendeeCommand.getPhoneNumber();
        return attendee;
    }

    public static Attendee create(final ResponseAttendeeDTO responseAttendeeDTO) {
        final Attendee attendee = new Attendee();

        attendee.firstName = responseAttendeeDTO.getFirstname();
        attendee.lastName = responseAttendeeDTO.getLastname();
        attendee.email = responseAttendeeDTO.getEmail();
        attendee.phoneNumber = responseAttendeeDTO.getPhone();
        return attendee;
    }
}
