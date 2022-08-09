package io.xhub.xquiz.service.attendee;

import io.xhub.xquiz.command.AttendeeCommand;
import io.xhub.xquiz.domain.Attendee;
import io.xhub.xquiz.repository.AttendeeRepository;
import io.xhub.xquiz.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AttendeeServiceImpl implements AttendeeService {

    private final AttendeeRepository attendeeRepository;

    @Override
    public void create(AttendeeCommand attendeeCommand) {
        attendeeCommand.validate();
        log.info("Begin registering new user with payload {}", JSONUtil.toJSON(attendeeCommand));
        attendeeRepository.save(Attendee.create(attendeeCommand));
    }
}
