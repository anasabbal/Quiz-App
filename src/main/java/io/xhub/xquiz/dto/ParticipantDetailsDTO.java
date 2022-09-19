package io.xhub.xquiz.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public class ParticipantDetailsDTO {

    private final String firstName;
    private final String lastName;
    private final String seniorityLevel;
    private final String subTheme;
    private final String theme;
    private final LocalDateTime dateOfQuiz;
    private final String goodyTaken;
    private final long technicalQuizScore;
    private final long culturalQuizScore;
}
