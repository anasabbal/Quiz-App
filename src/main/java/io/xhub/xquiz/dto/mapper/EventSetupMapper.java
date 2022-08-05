package io.xhub.xquiz.dto.mapper;

import io.xhub.xquiz.domain.EventSetup;
import io.xhub.xquiz.dto.EventSetupDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EventFormSetupMapper.class})
public abstract class EventSetupMapper {

    public abstract List<EventSetupDTO> toDTO(List<EventSetup> eventSetups);

    public abstract EventSetupDTO toDTO(EventSetup eventSetup);
}
