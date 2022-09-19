package io.xhub.xquiz.service.participant;

import io.xhub.xquiz.dto.ParticipantDetailsDTO;
import io.xhub.xquiz.repository.AttendeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ParticipantServiceImpl implements ParticipantService {

    private final AttendeeRepository attendeeRepository;

    /**
     * @param keyword only matches the firstName and lastName of the participant - default is _
     * @return a page of DTO projections of Participants Details
     */
    @Override
    public Page<ParticipantDetailsDTO> getAllByCriteria(final String keyword, final Pageable pageable) {
        log.info("Start fetching participants details that match keyword '{}'", keyword);
        return attendeeRepository.findAllParticipantDetailsByCriteria(keyword, pageable);
    }
}