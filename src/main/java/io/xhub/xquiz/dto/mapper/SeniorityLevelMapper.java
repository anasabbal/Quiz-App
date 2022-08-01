package io.xhub.xquiz.dto.mapper;


import io.xhub.xquiz.domain.SeniorityLevel;
import io.xhub.xquiz.dto.SeniorityLevelDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class SeniorityLevelMapper {
    public abstract SeniorityLevelDTO toSeniorityLevelDTO(SeniorityLevel seniorityLevel);

    public abstract List<SeniorityLevelDTO> toListSeniorityLevelDTO(List<SeniorityLevel> seniorityLevel);
}
