package io.xhub.xquiz.service.attendeeevent;

import io.xhub.xquiz.domain.Attendee;
import io.xhub.xquiz.domain.AttendeeEvent;
import io.xhub.xquiz.domain.Event;
import io.xhub.xquiz.repository.AttendeeEventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AttendeeEventServiceImpl implements AttendeeEventService {

    private final AttendeeEventRepository attendeeEventRepository;

    @Override
    public AttendeeEvent getOrCreateAttendeeEvent(final Attendee attendee, final Event event) {
        log.info("Begin fetching attendee event with attendee id {} and event id {}", attendee.getId(), event.getId());
        return attendeeEventRepository.findByAttendeeAndEvent(attendee.getEmail(), event.getId())
                .orElseGet(() -> create(attendee, event));
    }

    private AttendeeEvent create(final Attendee attendee, final Event event) {
        return attendeeEventRepository.save(AttendeeEvent.create(attendee, event));
    }
}
