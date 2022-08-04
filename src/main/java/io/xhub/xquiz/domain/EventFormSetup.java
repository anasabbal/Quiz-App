package io.xhub.xquiz.domain;

import io.xhub.xquiz.enums.SubmitMethod;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Table(name = "EVENT_FORM_SETUP")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class EventFormSetup extends BaseEntity {


    @Column(name = "FORM_NAME")
    private String formName;
    @Column(name = "FORM_TITLE")
    private String formTitle;

    @Column(name = "SUBMIT_URL")
    private String submitUrl;
    @Column(name = "SUBMIT_METHOD")
    private SubmitMethod submitMethod;

    // todo: enhance this mapping
    @OneToMany
    private List<EventFormElement> elements;
}
