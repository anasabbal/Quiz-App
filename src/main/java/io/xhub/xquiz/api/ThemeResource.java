package io.xhub.xquiz.api;


import io.xhub.xquiz.dto.SubThemeDTO;
import io.xhub.xquiz.dto.ThemeDTO;
import io.xhub.xquiz.dto.mapper.ThemeMapper;
import io.xhub.xquiz.service.subtheme.SubThemeService;
import io.xhub.xquiz.service.theme.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static io.xhub.xquiz.constants.ResourcePath.*;

@RestController
@RequestMapping(V1 + THEMES)
@RequiredArgsConstructor
public class ThemeResource {

    private final ThemeService themeService;
    private final ThemeMapper themeMapper;
    private final SubThemeService subThemeService;

    @GetMapping
    public ResponseEntity<List<ThemeDTO>> getThemes(){
        return ResponseEntity.ok(themeMapper.toListThemes(themeService.getThemes()));
    }

    @GetMapping("/{themeId}"+ SUB_THEMES)
    public ResponseEntity<Page<SubThemeDTO>> getSubThemesByThemeId(@PathVariable("themeId") String themeId, Pageable pageable){
        return ResponseEntity.ok(subThemeService.findAllSubThemeByTheme(themeId, pageable));
    }
}
