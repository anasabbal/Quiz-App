package io.xhub.xquiz.service.event;

import io.xhub.xquiz.command.CreateEventSessionCommand;
import io.xhub.xquiz.criteria.EventCriteria;
import io.xhub.xquiz.domain.Event;
import io.xhub.xquiz.domain.EventSetup;
import io.xhub.xquiz.domain.User;
import io.xhub.xquiz.dto.EventDTO;
import io.xhub.xquiz.dto.ResponseDTO;
import io.xhub.xquiz.dto.mapper.EventMapper;
import io.xhub.xquiz.enums.SubmitMethod;
import io.xhub.xquiz.exception.BusinessException;
import io.xhub.xquiz.exception.ExceptionPayloadFactory;
import io.xhub.xquiz.repository.EventRepository;
import io.xhub.xquiz.repository.EventSetupRepository;
import io.xhub.xquiz.repository.UserRepository;
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
import java.util.Objects;

@RequiredArgsConstructor
@Service
@ConditionalOnProperty(prefix = "fake-service", name = "enabled", havingValue = "false", matchIfMissing = false)
public class EventServiceImp implements EventService {
    private final UserRepository userRepository;
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


        User user = null;

        try {
            if (Objects.isNull(eventSetup.getSubmitUrl())) {
                user = getOrCreateUser(body);
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
                user = saveNewUser(userResponse);
            }

            if (Objects.isNull(user)) {
                // todo: fix this!
                throw new RuntimeException("user was not created for some reason! mostly a bug");
            }

            createEventSession(event, eventSetup, user);

        } catch (RestClientException e) {
            if (Objects.isNull(user)) {
                // todo: fix this!
                throw new RuntimeException("could not communicate with client to get user information");
            }
        }

        return user;
    }

    private void createEventSession(Event event, EventSetup eventSetup, User user) {

    }

    private User getOrCreateUser(CreateEventSessionCommand body) {
        // todo: fixme
        return null;
    }

    private User saveNewUser(ResponseDTO responseDTO) {
        Boolean exists = this.checkIfUserExists(responseDTO.getEmail());
        if (Boolean.TRUE.equals(exists)) {
            throw new BusinessException(ExceptionPayloadFactory.USER_ALREADY_EXISTS.get());
        }
        User user = User.create(responseDTO);
        return userRepository.save(user);
    }

    private Boolean checkIfUserExists(String email) {
        return userRepository.existsByEmail(email);
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
