package io.xhub.xquiz.domain;


import io.xhub.xquiz.enums.SubmitMethod;
import lombok.*;

import javax.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private SubmitMethod submitMethod;

    @OneToMany(mappedBy = "eventFormSetup", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EventFormElement> elements;

    @ManyToOne
    @JoinColumn(name = "THEME_ID")
    private EventTheme theme;
}
