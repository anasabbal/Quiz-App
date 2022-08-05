package io.xhub.xquiz.dto.mapper;


import io.xhub.xquiz.domain.EventTheme;
import io.xhub.xquiz.dto.EventThemeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class EventThemeMapper {

    public abstract EventThemeDTO toDTO(EventTheme eventTheme);
}
