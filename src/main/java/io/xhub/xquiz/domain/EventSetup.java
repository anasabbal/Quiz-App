package io.xhub.xquiz.domain;

import io.xhub.xquiz.dto.EventFormSetupDTO;
import io.xhub.xquiz.enums.EventSetupType;
import io.xhub.xquiz.enums.SubmitMethod;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

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
    private EventSetupType kind;
    @Column(name = "INITIALIZE_BUTTON_TEXT")
    private String initializeButtonText;
    @OneToOne
    private EventFormSetup formSetup;


    @Column(name = "SUBMIT_URL")
    private String submitUrl;
    @Column(name = "SUBMIT_METHOD")
    private SubmitMethod submitMethod;


}
