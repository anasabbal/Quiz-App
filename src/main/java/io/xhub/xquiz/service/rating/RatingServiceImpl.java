package io.xhub.xquiz.service.rating;


import io.xhub.xquiz.command.RatingCommand;
import io.xhub.xquiz.domain.Attendee;
import io.xhub.xquiz.domain.Rating;
import io.xhub.xquiz.exception.BusinessException;
import io.xhub.xquiz.exception.ExceptionPayloadFactory;
import io.xhub.xquiz.repository.QuizInstanceRepository;
import io.xhub.xquiz.repository.RatingRepository;
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
    private final QuizInstanceRepository quizInstanceRepository;


    @Override
    public Rating createRating(String quizInstanceId, RatingCommand ratingCommand) {
        ratingCommand.validate();
        log.info("Begin fetching session with id {}", quizInstanceId);
        final Attendee attendee = quizInstanceRepository.findAttendeeByQuizInstance(quizInstanceId).orElseThrow(
                () -> new BusinessException(ExceptionPayloadFactory.ATTENDEE_NOT_FOUND.get())
        );
        final Rating rating = ratingRepository.findRatingByAttendee(attendee).orElseGet(
                        ()  -> Rating.create(ratingCommand, attendee));
        rating.setRatingScore(ratingCommand.getRatingScore());
        rating.setContent(ratingCommand.getContent());
        log.info("Rating has been added successfully from attendee with id {}", attendee.getId());

        return ratingRepository.save(rating);
    }
}
