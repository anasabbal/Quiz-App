package io.xhub.xquiz.domain;

import io.xhub.xquiz.enums.EventSetupType;
import io.xhub.xquiz.enums.SubmitMethod;
import lombok.*;

import javax.persistence.*;

@Table(name = "EVENT_SETUP")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class EventSetup extends BaseEntity {

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "KIND")
    @Enumerated(EnumType.STRING)
    private EventSetupType kind;

    @Column(name = "INITIALIZE_BUTTON_TEXT")
    private String initializeButtonText;

    @OneToOne
    private EventFormSetup formSetup;


    @Column(name = "SUBMIT_URL")
    private String submitUrl;

    @Column(name = "SUBMIT_METHOD")
    @Enumerated(EnumType.STRING)
    private SubmitMethod submitMethod;

    @ManyToOne
    private Event event;
}
