package io.xhub.xquiz.domain;

import io.xhub.xquiz.command.CreateEventSessionCommand;
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

    public static Attendee create(final CreateEventSessionCommand command) {
        final Attendee attendee = new Attendee();

        attendee.firstName = command.getPayload().get("firstName");
        attendee.lastName = command.getPayload().get("lastName");
        attendee.email = command.getPayload().get("email");
        attendee.phoneNumber = command.getPayload().get("phoneNumber");
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
