package io.xhub.xquiz.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingDTO {

    private String attendeeId;
    private Integer ratingScore;
    private String content;
}
