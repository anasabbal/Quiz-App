package io.xhub.xquiz.dto.mapper;


import io.xhub.xquiz.domain.Answer;
import io.xhub.xquiz.dto.AnswerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AnswerMapper {
    public abstract AnswerDTO toAnswerDTO(Answer answer);
}
