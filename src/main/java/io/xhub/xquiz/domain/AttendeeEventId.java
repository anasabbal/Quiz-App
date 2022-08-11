package io.xhub.xquiz.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
public class AttendeeEventId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Attendee attendee;
}
