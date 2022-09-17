package io.xhub.xquiz.service.rating;


import io.xhub.xquiz.command.RatingCommand;
import io.xhub.xquiz.domain.Attendee;
import io.xhub.xquiz.domain.Rating;
import io.xhub.xquiz.repository.RatingRepository;
import io.xhub.xquiz.service.quizinstance.QuizInstanceService;
import io.xhub.xquiz.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class RatingServiceImpl implements RatingService{

    private final RatingRepository ratingRepository;
    private final QuizInstanceService quizInstanceService;

    @Override
    public Rating createRating(String quizInstanceId, RatingCommand ratingCommand) {
        ratingCommand.validate();
        log.info("Begin fetching session with id {}", quizInstanceId);
        final Attendee attendee = quizInstanceService.getAttendeeByQuizInstanceId(quizInstanceId);

        log.info("Begin fetching rating with attendee id {} or create new rating with payload ", attendee.getId(), JSONUtil.toJSON(ratingCommand));
        final Rating rating = ratingRepository.findRatingByAttendee(attendee).orElseGet(
                        ()  -> Rating.create(ratingCommand, attendee));
        rating.setRatingScore(ratingCommand.getRatingScore());
        rating.setContent(ratingCommand.getContent());
        log.info("Rating has been added successfully from attendee with id {}", attendee.getId());

        return ratingRepository.save(rating);
    }
}
