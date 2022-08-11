package io.xhub.xquiz.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseAttendeeDTO {

    private String firstname;
    private String lastname;
    private String email;
    private String phone;

}
