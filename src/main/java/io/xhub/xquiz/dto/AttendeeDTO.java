package io.xhub.xquiz.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AttendeeDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

}
