package io.xhub.xquiz.service.event;

import io.xhub.xquiz.command.CreateEventSessionCommand;
import io.xhub.xquiz.criteria.EventCriteria;
import io.xhub.xquiz.domain.Attendee;
import io.xhub.xquiz.domain.Event;
import io.xhub.xquiz.domain.EventSetup;
import io.xhub.xquiz.dto.EventDTO;
import io.xhub.xquiz.dto.ResponseDTO;
import io.xhub.xquiz.dto.mapper.EventMapper;
import io.xhub.xquiz.enums.SubmitMethod;
import io.xhub.xquiz.exception.BusinessException;
import io.xhub.xquiz.exception.ExceptionPayload;
import io.xhub.xquiz.exception.ExceptionPayloadFactory;
import io.xhub.xquiz.repository.EventRepository;
import io.xhub.xquiz.repository.EventSetupRepository;
import io.xhub.xquiz.repository.AttendeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.transaction.NotSupportedException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@ConditionalOnProperty(prefix = "fake-service", name = "enabled", havingValue = "false", matchIfMissing = false)
public class EventServiceImp implements EventService {
    private final AttendeeRepository attendeeRepository;
    private final EventRepository eventRepository;
    private final EventSetupRepository eventSetupRepository;
    private final EventMapper eventMapper;

    @Override
    public EventDTO getEvent(String id) {
        final Event event = eventRepository
                .findById(id)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.EVENT_NOT_FOUND.get()));
        return eventMapper.toEventDTO(event);
    }

    @Override
    @Transactional
    public Page<EventDTO> getEventsByCriteria(Pageable pageable, EventCriteria eventCriteria) {
        Page<Event> events = eventRepository.findAllEventsSortByDateWithCriteria(pageable, eventCriteria);
        return events.map(eventMapper::toEventDTO);
    }

    @Override
    @Transactional
    public Object createSession(CreateEventSessionCommand body) {
        final Event event = eventRepository.findById(body.getEventId())
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.EVENT_NOT_FOUND.get()));

        final EventSetup eventSetup = eventSetupRepository.findById(body.getEventSetupId())
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.EVENT_SETUP_NOT_FOUND.get()));


        Attendee attendee = null;

        try {
            if (Objects.isNull(eventSetup.getSubmitUrl())) {
                attendee = getOrCreateUser(body);
            } else {
                final RestTemplate template = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                HttpEntity<?> entity = new HttpEntity<>(headers);
                final HttpEntity request = new HttpEntity(body.getPayload());
                final HttpMethod method = getHttpSubmitMethod(eventSetup.getSubmitMethod());
                final ResponseEntity<ResponseDTO> response = template.exchange(
                        eventSetup.getSubmitUrl(),
                        method,
                        entity,
                        ResponseDTO.class,
                        body.getPayload()
                );
                ensureResponseIsOk(response);
                ResponseDTO userResponse = response.getBody();
                attendee = saveNewUser(userResponse);
            }

            if (Objects.isNull(attendee)) {
                // todo: fix this!
                throw new RuntimeException("attendee was not created for some reason! mostly a bug");
            }

            createEventSession(event, eventSetup, attendee);

        } catch (RestClientException e) {
            if (Objects.isNull(attendee)) {
                // todo: fix this!
                throw new RuntimeException("could not communicate with client to get attendee information");
            }
        }

        return attendee;
    }

    private void createEventSession(Event event, EventSetup eventSetup, Attendee attendee) {

    }

    private Attendee getOrCreateUser(CreateEventSessionCommand body) {
        // todo: fixme
        return null;
    }

    private Attendee saveNewUser(ResponseDTO responseDTO) {
        Boolean exists = this.checkIfUserExists(responseDTO.getEmail());
        if (Boolean.TRUE.equals(exists)) {
            throw new BusinessException(ExceptionPayloadFactory.ATTENDEE_ALREADY_EXISTS.get());
        }
        Attendee attendee = Attendee.create(responseDTO);
        return attendeeRepository.save(attendee);
    }

    private Boolean checkIfUserExists(String email) {
        return attendeeRepository.existsByEmail(email);
    }

    private void ensureResponseIsOk(ResponseEntity<ResponseDTO> response) {
        if (!HttpStatus.OK.equals(response.getStatusCode())) {
            // todo: fix this!
            throw new RuntimeException("status is not ok");
        }
    }

    private HttpMethod getHttpSubmitMethod(SubmitMethod submitMethod) {
        if (SubmitMethod.GET.equals(submitMethod)) {
            return HttpMethod.GET;
        }
        if (SubmitMethod.POST.equals(submitMethod)) {
            return HttpMethod.POST;
        }
        // todo: fix this!
        throw new RuntimeException(new NotSupportedException(submitMethod.toString()));
    }

}
