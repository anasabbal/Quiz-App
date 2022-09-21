package io.xhub.xquiz.dto.mapper;

import io.xhub.xquiz.domain.CultureQuestion;
import io.xhub.xquiz.dto.CultureQuestionDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CultureQuestionMapper {

    public abstract CultureQuestionDTO toCultureQuestionDTO(CultureQuestion cultureQuestion);

}