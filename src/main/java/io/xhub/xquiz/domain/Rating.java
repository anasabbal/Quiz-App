package io.xhub.xquiz.domain;


import io.xhub.xquiz.command.RatingCommand;
import lombok.*;

import javax.persistence.*;

@Table(name = "RATINGS")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Rating extends BaseEntity{


    @Column(name = "RATING_SCORE")
    private Integer ratingScore;

    @OneToOne
    private Attendee attendee;

    @Column(name = "CONTENT")
    private String content;

    public static Rating create(final RatingCommand ratingCommand, final Attendee attendee){
        final Rating rating = new Rating();

        rating.attendee = attendee;
        rating.content = ratingCommand.getContent();
        rating.ratingScore = ratingCommand.getRatingScore();

        return rating;
    }
}
