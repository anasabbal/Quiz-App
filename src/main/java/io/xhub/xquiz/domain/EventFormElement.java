package io.xhub.xquiz.domain;

import io.xhub.xquiz.enums.FormElementType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "EVENT_FORM_ELEMENT")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class EventFormElement extends BaseEntity {


    @Column(name = "TYPE")
    private FormElementType type;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PLACEHOLDER")
    private String placeholder;
    @Column(name = "REQUIRED")
    private Boolean required;
    @Column(name = "HTML_TYPE")
    private String htmlType;
}
