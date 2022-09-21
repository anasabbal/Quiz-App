package io.xhub.xquiz.dto.mapper;

import io.xhub.xquiz.domain.CultureAnswer;
import io.xhub.xquiz.dto.CultureAnswerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CultureAnswerMapper {

    public abstract CultureAnswerDTO toCultureAnswerDTO(CultureAnswer cultureAnswer);
}
