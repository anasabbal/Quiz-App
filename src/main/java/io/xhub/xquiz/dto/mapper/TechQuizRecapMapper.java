package io.xhub.xquiz.dto.mapper;

import io.xhub.xquiz.dto.TechQuizRecapAnswersDTO;
import io.xhub.xquiz.dto.TechQuizRecapDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TechQuizRecapMapper {

    public TechQuizRecapDTO toTechQuizRecapDTO(List<TechQuizRecapAnswersDTO> source, Integer score , Long timePassed) {
        final TechQuizRecapDTO techQuizRecapDTO = new TechQuizRecapDTO();
        techQuizRecapDTO.setScore(score);
        techQuizRecapDTO.setQuizContent(source);
        techQuizRecapDTO.setTimePassed(timePassed);

        return techQuizRecapDTO;
    }
}
