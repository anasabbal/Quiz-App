package io.xhub.xquiz.service.subtheme;



import io.xhub.xquiz.dto.SubThemeDTO;
import io.xhub.xquiz.dto.mapper.SubThemeMapper;
import io.xhub.xquiz.repository.SubThemeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class SubThemeServiceImpl implements SubThemeService {

    private final SubThemeRepository subThemeRepository;
    private final SubThemeMapper subThemeMapper;


    @Override
    public Page<SubThemeDTO> findAllSubThemeByTheme(String themeId, Pageable pageable) {
        log.info("Begin fetching theme with id {}", themeId);
        return subThemeRepository.findAllSubThemeByThemeId(themeId, pageable).map(subThemeMapper::toSubThemeDTO);
    }
}
