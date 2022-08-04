package io.xhub.xquiz.api;

import io.xhub.xquiz.command.UserCommand;
import io.xhub.xquiz.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.xhub.xquiz.constants.ResourcePath.USERS;
import static io.xhub.xquiz.constants.ResourcePath.V1;

@RestController
@RequestMapping(V1 + USERS)
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody final UserCommand userCommand) {
        userService.create(userCommand);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
