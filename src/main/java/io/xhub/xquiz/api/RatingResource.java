package io.xhub.xquiz.api;


import io.xhub.xquiz.command.RatingCommand;
import io.xhub.xquiz.domain.Rating;
import io.xhub.xquiz.service.rating.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static io.xhub.xquiz.constants.ResourcePath.RATE_EXPERIENCE;
import static io.xhub.xquiz.constants.ResourcePath.V1;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping(V1 + RATE_EXPERIENCE)
@RequiredArgsConstructor
public class RatingResource {

    private final RatingService ratingService;

    @PostMapping("/{quizInstanceId}")
    public ResponseEntity<Void> addRating(@PathVariable("quizInstanceId") final String quizInstanceId,
                                          @RequestBody final RatingCommand ratingCommand){
        final Rating rating = ratingService.createRating(quizInstanceId, ratingCommand);
        final URI uri = fromCurrentRequest().path("/{id}").buildAndExpand( rating.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}