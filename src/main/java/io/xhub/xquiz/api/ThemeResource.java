package io.xhub.xquiz.api;


import io.xhub.xquiz.dto.ThemeDTO;
import io.xhub.xquiz.dto.mapper.ThemeMapper;
import io.xhub.xquiz.service.theme.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static io.xhub.xquiz.constants.ResourcePath.THEMES;
import static io.xhub.xquiz.constants.ResourcePath.V1;

@RestController
@RequestMapping(V1 + THEMES)
@RequiredArgsConstructor
public class ThemeResource {

    private final ThemeService themeService;
    private final ThemeMapper themeMapper;

    @GetMapping
    public ResponseEntity<List<ThemeDTO>> getThemes(){
        return ResponseEntity.ok(themeMapper.toListThemes(themeService.getThemes()));
    }
}
