package io.xhub.xquiz.criteria;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class EventCriteria {
    private final String name;
    private final Boolean active;
}
