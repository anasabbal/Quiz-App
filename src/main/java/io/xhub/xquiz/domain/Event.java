package io.xhub.xquiz.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "events")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Event extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "LOGO_ID")
    private String logoId;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "LOCATION")
    private String location;


    @Column(name = "COVER_IMAGE_ID")
    private String coverImageId;


    @Column(name = "PRIMARY_COLOR")
    private String primaryColor;

    @Column(name = "SECONDARY_COLOR")
    private String secondaryColor;

}
