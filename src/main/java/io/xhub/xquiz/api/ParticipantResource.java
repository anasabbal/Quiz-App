package io.xhub.xquiz.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.xhub.xquiz.dto.ParticipantDetailsDTO;
import io.xhub.xquiz.service.participant.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static io.xhub.xquiz.constants.ResourcePath.PARTICIPANTS;
import static io.xhub.xquiz.constants.ResourcePath.V1;

@RestController
@Api(tags = "Participants Query Resource")
@RequestMapping(value = V1 + PARTICIPANTS)
@RequiredArgsConstructor
public class ParticipantResource {

    private final ParticipantService participantService;

    @GetMapping
    @ApiOperation(value = "Page of participants details that have finished a session in xQuiz")
    public ResponseEntity<Page<ParticipantDetailsDTO>> getAll(
            @RequestParam(value = "keyword", required = false, defaultValue = "_") String keyword, Pageable pageable) {
        return ResponseEntity.ok(participantService.getAllByCriteria(keyword, pageable));
    }
}
