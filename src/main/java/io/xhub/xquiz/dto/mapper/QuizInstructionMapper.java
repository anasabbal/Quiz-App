package io.xhub.xquiz.dto.mapper;


import io.xhub.xquiz.domain.QuizInstruction;
import io.xhub.xquiz.dto.QuizInstructionDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class QuizInstructionMapper {
    public abstract QuizInstructionDTO toQuizInstructionDTO(QuizInstruction quizInstruction);
    public abstract List<QuizInstructionDTO> dtoList(List<QuizInstruction> quizInstructions);
}
