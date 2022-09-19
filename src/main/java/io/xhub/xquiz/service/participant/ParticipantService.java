package io.xhub.xquiz.service.participant;

import io.xhub.xquiz.dto.ParticipantDetailsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ParticipantService {
    Page<ParticipantDetailsDTO> getAllByCriteria(String keyword, Pageable pageable);
}
