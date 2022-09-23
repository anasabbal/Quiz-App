package io.xhub.xquiz.domain.projection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ParticipantGoodiesDTO {

    private final String id;
    private final String label;
    private final Integer stock;
    private final Boolean isEligible;
    private final Boolean isAcquired;
}
