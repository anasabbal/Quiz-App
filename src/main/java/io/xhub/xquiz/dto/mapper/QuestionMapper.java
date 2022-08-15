package io.xhub.xquiz.dto.mapper;


import io.xhub.xquiz.domain.Question;
import io.xhub.xquiz.dto.QuestionDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class QuestionMapper {
    public abstract QuestionDTO toQuestionDTO(Question question);
    public abstract List<QuestionDTO> toList(List<Question> question);
}
