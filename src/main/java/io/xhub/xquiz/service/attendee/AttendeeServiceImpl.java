package io.xhub.xquiz.service.attendee;

import io.xhub.xquiz.command.CreateEventSessionCommand;
import io.xhub.xquiz.domain.Attendee;
import io.xhub.xquiz.dto.ResponseAttendeeDTO;
import io.xhub.xquiz.repository.AttendeeRepository;
import io.xhub.xquiz.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AttendeeServiceImpl implements AttendeeService {

    private final AttendeeRepository attendeeRepository;

    @Override
    public Attendee getOrCreateAttendee(final ResponseAttendeeDTO response) {
        Optional<Attendee> attendee = attendeeRepository.findByEmail(response.getEmail());
        if (attendee.isEmpty()) {
            log.info("Begin registering new attendee with payload {}", JSONUtil.toJSON(response));
            return attendeeRepository.save(Attendee.create(response));
        }
        return attendee.get();
    }

    @Override
    public Attendee getOrCreateAttendee(final CreateEventSessionCommand body) {
        body.validate();
        Optional<Attendee> attendee = attendeeRepository.findByEmail(body.getPayload().get("email"));
        if (attendee.isEmpty()) {
            log.info("Begin registering new attendee with payload {}", JSONUtil.toJSON(body.getPayload()));
            return attendeeRepository.save(Attendee.create(body));
        }
        return attendee.get();
    }

}
