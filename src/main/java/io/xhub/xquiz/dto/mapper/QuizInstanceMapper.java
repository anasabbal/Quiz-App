package io.xhub.xquiz.dto.mapper;

import io.xhub.xquiz.domain.QuizInstance;
import io.xhub.xquiz.dto.QuizInstanceDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class QuizInstanceMapper {
    public abstract QuizInstanceDTO toQuizInstanceDTO(QuizInstance quizInstance);
}
