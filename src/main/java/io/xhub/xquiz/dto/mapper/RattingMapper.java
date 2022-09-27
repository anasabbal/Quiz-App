package io.xhub.xquiz.dto.mapper;

import io.xhub.xquiz.domain.QuizInstruction;
import io.xhub.xquiz.domain.Rating;
import io.xhub.xquiz.dto.QuizInstructionDTO;
import io.xhub.xquiz.dto.RatingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class RattingMapper {
    @Mapping(target="attendeeId", source = "rating.id")
    @Mapping(target="content", source = "rating.content")
    public abstract RatingDTO toRatingDTO(Rating rating);
}