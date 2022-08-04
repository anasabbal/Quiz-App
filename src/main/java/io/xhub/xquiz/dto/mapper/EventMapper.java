package io.xhub.xquiz.dto.mapper;

import io.xhub.xquiz.domain.Event;
import io.xhub.xquiz.dto.EventDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class EventMapper {

    public abstract List<EventDTO> toEventDTO (List<Event> events);
    public abstract EventDTO toEventDTO (Event event);
}
