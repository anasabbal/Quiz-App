package io.xhub.xquiz.domain.projection;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class ParticipantCulturalQuizAnswerDTO {

    private final String id;
    private final String question;
    private final String answer;
}
