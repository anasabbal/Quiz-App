package io.xhub.xquiz.dto.mapper;

import io.xhub.xquiz.dto.ParticipantDetailsCountDTO;
import io.xhub.xquiz.dto.ParticipantDetailsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ParticipantMapper {

    public ParticipantDetailsCountDTO toParticipantDetailsCountDTO(Page<ParticipantDetailsDTO> participantsPage, int participantCount) {
        return ParticipantDetailsCountDTO.builder().participantPage(participantsPage).count(participantCount).build();
    }
}
