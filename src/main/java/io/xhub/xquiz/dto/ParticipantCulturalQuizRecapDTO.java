package io.xhub.xquiz.dto;

import io.xhub.xquiz.domain.projection.ParticipantCulturalQuizAnswerDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParticipantCulturalQuizRecapDTO {
    private Integer finalScorePercentage;
    private List<ParticipantCulturalQuizAnswerDTO> answers;

    public static ParticipantCulturalQuizRecapDTO create(final Integer finalScorePercentage, final List<ParticipantCulturalQuizAnswerDTO> answers) {
        final ParticipantCulturalQuizRecapDTO participantCulturalQuizRecapDTO = new ParticipantCulturalQuizRecapDTO();
        participantCulturalQuizRecapDTO.setFinalScorePercentage(finalScorePercentage);
        participantCulturalQuizRecapDTO.setAnswers(answers);
        return participantCulturalQuizRecapDTO;
    }
}
