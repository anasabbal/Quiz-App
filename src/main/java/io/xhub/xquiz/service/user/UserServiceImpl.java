package io.xhub.xquiz.service.user;

import io.xhub.xquiz.command.UserCommand;
import io.xhub.xquiz.domain.User;
import io.xhub.xquiz.repository.UserRepository;
import io.xhub.xquiz.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void create(UserCommand userCommand) {
        userCommand.validate();
        log.info("Begin registering new user with payload {}", JSONUtil.toJSON(userCommand));
        userRepository.save(User.create(userCommand));
    }
}
