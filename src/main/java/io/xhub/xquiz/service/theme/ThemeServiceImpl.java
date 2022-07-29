package io.xhub.xquiz.service.theme;

import io.xhub.xquiz.domain.Theme;
import io.xhub.xquiz.repository.ThemeRepository;
import io.xhub.xquiz.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
@Slf4j
public class ThemeServiceImpl implements ThemeService{

    private final ThemeRepository themeRepository;

    @Override
    public List<Theme>getThemes() {
        log.info("Begin fetching themes ");
        List<Theme> themes = themeRepository.findAll();
        log.info("Themes with payload {} fetched successfully", JSONUtil.toJSON(themes));
        return themes;
    }
}
