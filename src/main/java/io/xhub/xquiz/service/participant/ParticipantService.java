package io.xhub.xquiz.service.participant;

import io.xhub.xquiz.command.FeedBackCommand;
import io.xhub.xquiz.command.ParticipantGoodyCommand;
import io.xhub.xquiz.domain.*;
import io.xhub.xquiz.domain.projection.ParticipantDetailDTO;
import io.xhub.xquiz.domain.projection.ParticipantGoodiesDTO;
import io.xhub.xquiz.dto.ParticipantCulturalQuizRecapDTO;
import io.xhub.xquiz.dto.TechQuizRecapAnswersDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ParticipantService {
    List<ParticipantGoodiesDTO> getGoodies(String eventID, String participantID);

    void giftGoody(String eventID, String participantID, ParticipantGoodyCommand command);

    Goody getGoody(String id);

    Page<ParticipantDetailDTO> getAllEventParticipantsByCriteria(String keyword, Pageable pageable);

    void submitFeedback(String eventIDn, String participantID, FeedBackCommand feedBackCommand);

    AttendeeEvent getEventParticipant(String eventID, String participantID);


    Feedback getFeedback(String eventID, String participantID);

    ParticipantCulturalQuizRecapDTO getCulturalQuizRecap(String participantID, String eventID);

    List<TechQuizRecapAnswersDTO> getTechnicalQuizRecap(final String eventIdD, final String participantID);

    Integer getEventParticipantTechnicalQuizPercentScore(String eventID, String participantID);

    Long getTimePassed(String eventID, String participantID);
}
