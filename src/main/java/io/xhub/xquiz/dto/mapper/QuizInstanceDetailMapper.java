package io.xhub.xquiz.dto.mapper;



import io.xhub.xquiz.domain.QuizInstanceDetails;
import io.xhub.xquiz.dto.QuizInstanceDetailsDTO;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring", uses = {QuestionMapper.class})
public abstract class QuizInstanceDetailMapper {

    public abstract QuizInstanceDetailsDTO toQuizInstanceDetailsDTO(QuizInstanceDetails quizInstanceDetails);

    public abstract List<QuizInstanceDetailsDTO> toQuizInstanceDetailsDTO(List<QuizInstanceDetails> quizInstanceDetails);

    @AfterMapping
    public QuizInstanceDetailsDTO after(QuizInstanceDetails quizInstanceDetail, @MappingTarget QuizInstanceDetailsDTO quizInstanceDetails) {
        quizInstanceDetails.getQuestion().setIndex(quizInstanceDetail.getQuestionIndex());

        return quizInstanceDetails;
    }
}