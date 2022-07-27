package io.xhub.xquiz.service.user;

import io.xhub.xquiz.command.UserCommand;

public interface UserService {
    void create(UserCommand userCommand);
}
