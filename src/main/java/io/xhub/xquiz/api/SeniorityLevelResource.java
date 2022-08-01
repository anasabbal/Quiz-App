package io.xhub.xquiz.api;


import io.xhub.xquiz.domain.SeniorityLevel;
import io.xhub.xquiz.dto.SeniorityLevelDTO;
import io.xhub.xquiz.dto.mapper.SeniorityLevelMapper;
import io.xhub.xquiz.service.level.SeniorityLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static io.xhub.xquiz.constants.ResourcePath.*;

@RestController
@RequestMapping(V1 + SENIORITY_LEVELS)
@RequiredArgsConstructor
public class SeniorityLevelResource {

    private final SeniorityLevelService seniorityLevelService;
    private final SeniorityLevelMapper seniorityLevelMapper;

    @GetMapping
    public ResponseEntity<List<SeniorityLevelDTO>> getSeniorityLevels(){
        List<SeniorityLevel> listSeniorityLevels = seniorityLevelService.getSeniorityLevels();
        return ResponseEntity.ok(seniorityLevelMapper.toListSeniorityLevelDTO(listSeniorityLevels));
    }
}
