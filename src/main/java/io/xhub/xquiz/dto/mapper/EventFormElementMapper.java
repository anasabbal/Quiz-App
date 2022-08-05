package io.xhub.xquiz.dto.mapper;

import io.xhub.xquiz.domain.EventFormElement;
import io.xhub.xquiz.dto.EventFormElementDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class EventFormElementMapper {

    public abstract EventFormElementDTO toDTO(EventFormElement eventFormElement);

}
