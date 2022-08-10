package io.xhub.xquiz.service.theme;

import io.xhub.xquiz.domain.Theme;
import io.xhub.xquiz.repository.ThemeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ThemeServiceImpl implements ThemeService{

    private final ThemeRepository themeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Theme> getThemes() {
        log.info("Begin fetching themes ");
        List<Theme> themes = themeRepository.findThemesByDeletedFalse();
        log.info("Themes with size {} fetched successfully", themes.size());
        return themes;
    }
}
