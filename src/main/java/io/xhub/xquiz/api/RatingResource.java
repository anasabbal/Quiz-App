package io.xhub.xquiz.api;


import io.swagger.annotations.ApiOperation;
import io.xhub.xquiz.command.RatingCommand;
import io.xhub.xquiz.domain.Rating;
import io.xhub.xquiz.dto.RatingDTO;
import io.xhub.xquiz.dto.mapper.RattingMapper;
import io.xhub.xquiz.service.rating.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static io.xhub.xquiz.constants.ResourcePath.*;
import static io.xhub.xquiz.constants.ResourcePath.PARTICIPANTS_FEEDBACK;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping(V1 + RATE_EXPERIENCE)
@RequiredArgsConstructor
public class RatingResource {

    private final RatingService ratingService;
    private final RattingMapper rattingMapper;

    @PostMapping("/{quizInstanceId}")
    public ResponseEntity<Void> addRating(@PathVariable("quizInstanceId") final String quizInstanceId,
                                          @RequestBody final RatingCommand ratingCommand){
        final Rating rating = ratingService.createRating(quizInstanceId, ratingCommand);
        final URI uri = fromCurrentRequest().path("/{id}").buildAndExpand( rating.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping( PARTICIPANTS + "/{participantID}" + PARTICIPANTS_FEEDBACK)
    @ApiOperation(value = "Get participant rating on the xQuiz Participant session")
    public ResponseEntity<RatingDTO> getParticipantFeedBack(@PathVariable final String participantID) {
        return ResponseEntity.ok().body(rattingMapper.toRatingDTO(ratingService.getParticipantRating(participantID)));
    }
}