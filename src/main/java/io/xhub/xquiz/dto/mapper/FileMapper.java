package io.xhub.xquiz.dto.mapper;

import io.xhub.xquiz.domain.File;
import io.xhub.xquiz.dto.FileDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.io.ByteArrayInputStream;

@Mapper(componentModel = "spring")
public abstract class FileMapper {
    @Mapping(target = "inputStream", ignore = true)
    public abstract FileDTO toFileDTO(File file);

    @AfterMapping
    public void afterMapping(File file, @MappingTarget FileDTO fileDTO) {
        fileDTO.setInputStream(new ByteArrayInputStream(file.getContent()));
    }

}
