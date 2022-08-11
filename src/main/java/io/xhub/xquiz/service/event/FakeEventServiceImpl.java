package io.xhub.xquiz.service.event;

import io.xhub.xquiz.criteria.EventCriteria;
import io.xhub.xquiz.domain.Event;
import io.xhub.xquiz.dto.*;
import io.xhub.xquiz.enums.EventSetupType;
import io.xhub.xquiz.enums.SubmitMethod;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConditionalOnProperty(prefix = "fake-service", name = "enabled", havingValue = "true", matchIfMissing = true)
public class FakeEventServiceImpl implements EventService {

    @Override
    public Event getEvent(String id) {
        return null;
    }

    @Override
    public Page<Event> getEventsByCriteria(Pageable pageable, EventCriteria eventCriteria) {
        return null;
    }

    private List<EventThemeDTO> buildEventThemes() {
        EventThemeDTO themeDTO = EventThemeDTO.builder()
                .id("1")
                .active(Boolean.TRUE)
                .backgroundColor("#FF0000")
                .primaryColor("#FF7722")
                .secondaryColor("#FF6700")
                .backgroundImage("image-link")
                .build();
        return List.of(themeDTO);
    }

    private List<EventFormElementDTO> buildEventFormElements() {
        EventFormElementDTO firstNameInput = EventFormElementDTO.builder()
                .name("FIRST NAME")
                .placeholder("First name")
                .required(Boolean.TRUE)
                .type("INPUT")
                .htmlType("TEXT")
                .build();

        EventFormElementDTO lastNameInput = EventFormElementDTO.builder()
                .name("LAST NAME")
                .placeholder("Last name")
                .required(Boolean.TRUE)
                .type("INPUT")
                .htmlType("TEXT")
                .build();

        EventFormElementDTO emailInput = EventFormElementDTO.builder()
                .name("EMAIL")
                .placeholder("xAttendee@x-hub.io")
                .required(Boolean.TRUE)
                .type("INPUT")
                .htmlType("TEXT")
                .build();

        EventFormElementDTO registerButton = EventFormElementDTO.builder()
                .name("Register now")
                .type("BUTTON")
                .htmlType("button")
                .build();

        return List.of(firstNameInput, lastNameInput, emailInput, registerButton);
    }

    private List<EventSetupDTO> buildEventSetup() {

        EventSetupDTO setup = EventSetupDTO.builder()
                .id("1")
                .description("REDEVOXX SETUP")
                .title("DEVOXX")
                .initializeButtonText("Register now")
                .kind(EventSetupType.FORM)
                .formSetup(buildEventFormSetup())
                .build();

        return List.of(setup);
    }

    private EventFormSetupDTO buildEventFormSetup() {

        return EventFormSetupDTO.builder()
                .formName("REGISTRATION FORM")
                .formTitle("title")
                .submitUrl("http://localhost:8080/")
                .submitMethod(SubmitMethod.POST)
                .elements(buildEventFormElements())
                .build();

    }
}
