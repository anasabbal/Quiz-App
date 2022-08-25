package io.xhub.xquiz.service.rating;

import io.xhub.xquiz.command.RatingCommand;
import io.xhub.xquiz.domain.Rating;

public interface RatingService {
    Rating createRating(String quizInstanceId, final RatingCommand ratingCommand);
}