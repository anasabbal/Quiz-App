package io.xhub.xquiz.service.participant;

import io.xhub.xquiz.command.ParticipantGoodyCommand;
import io.xhub.xquiz.domain.Event;
import io.xhub.xquiz.domain.Goody;
import io.xhub.xquiz.dto.ParticipantDetailsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ParticipantService {
    List<Goody> getAllGoodies();

    void giftGoody(String participantID, ParticipantGoodyCommand command);

    Goody getById(String id);

    Page<ParticipantDetailsDTO> getAllByCriteria(String keyword, Pageable pageable);
    int countEventParticipants();
}
