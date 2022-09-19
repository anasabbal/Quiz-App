package io.xhub.xquiz.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.xhub.xquiz.command.ParticipantGoodyCommand;
import io.xhub.xquiz.dto.GoodyDTO;
import io.xhub.xquiz.dto.ParticipantDetailsCountDTO;
import io.xhub.xquiz.dto.mapper.GoodyMapper;
import io.xhub.xquiz.dto.mapper.ParticipantMapper;
import io.xhub.xquiz.service.participant.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static io.xhub.xquiz.constants.ResourcePath.*;

@RestController
@Api(tags = "Participants Query Resource")
@RequestMapping(value = V1 + PARTICIPANTS)
@RequiredArgsConstructor
public class ParticipantResource {

    private final ParticipantService participantService;
    private final ParticipantMapper participantMapper;
    private final GoodyMapper goodyMapper;

    @GetMapping
    @ApiOperation(value = "Page of participants details that have finished a session in xQuiz")
    public ResponseEntity<ParticipantDetailsCountDTO> getAll(
            @RequestParam(value = "keyword", required = false, defaultValue = "_") String keyword, Pageable pageable) {
        return ResponseEntity.ok(participantMapper
                .toParticipantDetailsCountDTO(
                        participantService.getAllByCriteria(keyword, pageable), participantService.countEventParticipants()));
    }


    @GetMapping("/{participantID}" + GOODIES)
    @ApiOperation(value = "List of all the participant's eligible goodies")
    public ResponseEntity<List<GoodyDTO>> getAllGoodies(@PathVariable final String participantID) {
        return ResponseEntity.ok(goodyMapper.toParticipantEligibleGoodiesDTOList(participantService.getAllGoodies(), participantID));
    }

    @PatchMapping("/{participantID}" + GOODIES)
    @ApiOperation(value = "Gift a Goody to a participant that has finished the xQuiz")
    public ResponseEntity<Void> giftGoody(@PathVariable final String participantID,
                                          @RequestBody final ParticipantGoodyCommand command) {
        participantService.giftGoody(participantID, command);
        return ResponseEntity.ok().build();
    }

}
