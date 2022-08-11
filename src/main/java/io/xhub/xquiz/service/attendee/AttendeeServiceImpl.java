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
    public Attendee create(final ResponseAttendeeDTO body) {
        log.info("Begin registering new attendee with payload {}", JSONUtil.toJSON(body));
        return attendeeRepository.save(Attendee.create(body));
    }

    @Override
    public Attendee getOrCreateAttendee(final CreateEventSessionCommand body) {
        Optional<Attendee> attendee = attendeeRepository.findByEmail(body.getPayload().get("email"));
        return attendee.orElseGet(
                () -> create(mapIntoResponse(body)));
    }

    private ResponseAttendeeDTO mapIntoResponse(final CreateEventSessionCommand body) {
        body.validate();
        ResponseAttendeeDTO responseAttendeeDTO = new ResponseAttendeeDTO();

        responseAttendeeDTO.setEmail(body.getPayload().get("email"));
        responseAttendeeDTO.setFirstname(body.getPayload().get("firstname"));
        responseAttendeeDTO.setLastname(body.getPayload().get("lastname"));
        responseAttendeeDTO.setPhone(body.getPayload().get("phone"));

        return responseAttendeeDTO;
    }

}
