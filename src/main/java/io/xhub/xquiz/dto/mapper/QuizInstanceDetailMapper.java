package io.xhub.xquiz.dto.mapper;



import io.xhub.xquiz.domain.QuizInstanceDetails;
import io.xhub.xquiz.domain.QuizInstruction;
import io.xhub.xquiz.dto.QuizInstanceDetailsDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {QuestionMapper.class, QuizInstructionMapper.class})
public abstract class QuizInstanceDetailMapper {

    @Mapping(target = "startDate", source = "quizInstanceDetails.quizInstance.startDate")
    @Mapping(target = "id", source = "quizInstanceDetails.id")
    @Mapping(target = "timeLimit", source = "quizInstruction.value")
    public abstract QuizInstanceDetailsDTO toQuizInstanceDetailsDTO(QuizInstanceDetails quizInstanceDetails, QuizInstruction quizInstruction);
}