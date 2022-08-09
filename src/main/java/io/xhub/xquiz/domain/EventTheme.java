package io.xhub.xquiz.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "EVENT_THEMES")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class EventTheme extends BaseEntity {

    @Column(name = "BACKGROUND_IMAGE")
    private String backgroundImage;

    @Column(name = "BACKGROUND_COLOR")
    private String backgroundColor;

    @Column(name = "PRIMARY_COLOR")
    private String primaryColor;

    @Column(name = "SECONDARY_COLOR")
    private String secondaryColor;

    @Column(name = "FONT_FAMILY")
    private String fontFamily;

    @ManyToOne
    private Event event;
}
