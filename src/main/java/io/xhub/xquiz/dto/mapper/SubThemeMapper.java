package io.xhub.xquiz.dto.mapper;


import io.xhub.xquiz.domain.SubTheme;
import io.xhub.xquiz.dto.SubThemeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class SubThemeMapper {
    public abstract SubThemeDTO toSubThemeDTO(SubTheme subTheme);
}
