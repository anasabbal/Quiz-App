package io.xhub.xquiz.api;

import io.xhub.xquiz.command.UserCommand;
import io.xhub.xquiz.dto.ResponseDTO;
import io.xhub.xquiz.feign.AttendeeFeignClient;
import io.xhub.xquiz.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

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
