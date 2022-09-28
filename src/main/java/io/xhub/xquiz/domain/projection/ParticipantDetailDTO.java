package io.xhub.xquiz.domain.projection;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class ParticipantDetailDTO {

    private final String id;
    private final String eventID;
    private final String firstName;
    private final String lastName;
    private final String seniorityLevel;
    private final String theme;
    private final LocalDateTime dateOfQuiz;
    private final String goodyTaken;
    private final float technicalQuizScore;
    private final float culturalQuizScore;
}
