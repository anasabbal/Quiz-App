package io.xhub.xquiz.dto.mapper;

import io.xhub.xquiz.domain.EventFormSetup;
import io.xhub.xquiz.dto.EventFormSetupDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EventFormElementMapper.class})
public abstract class EventFormSetupMapper {

    public abstract EventFormSetupDTO toDTO(EventFormSetup eventFormSetup);
}
