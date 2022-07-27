package io.xhub.xquiz.domain;

import io.xhub.xquiz.command.UserCommand;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "users")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    public static User create(final UserCommand userCommand) {
        final User user = new User();

        user.firstName = userCommand.getFirstName();
        user.lastName = userCommand.getLastName();
        user.email = userCommand.getEmail();
        user.phoneNumber = userCommand.getPhoneNumber();
        return user;
    }
}
