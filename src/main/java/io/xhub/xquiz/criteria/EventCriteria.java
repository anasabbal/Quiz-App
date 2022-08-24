package io.xhub.xquiz.criteria;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class EventCriteria {
    private final String name;
    private final Boolean active;
}
