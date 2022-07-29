package io.xhub.xquiz.dto.mapper;


import io.xhub.xquiz.domain.Theme;
import io.xhub.xquiz.dto.ThemeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ThemeMapper {

    public abstract ThemeDTO toThemeDTO(Theme theme);

    public abstract List<ThemeDTO> toListThemes(List<Theme> themes);
}
