package io.xhub.xquiz.dto.mapper;


import io.xhub.xquiz.domain.Feedback;
import io.xhub.xquiz.dto.FeedbackDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class FeedbackMapper {
    public abstract FeedbackDTO toFeedbackDTO(Feedback feedback);
}
