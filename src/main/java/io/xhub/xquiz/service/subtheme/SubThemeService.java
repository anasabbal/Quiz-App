package io.xhub.xquiz.service.subtheme;

import io.xhub.xquiz.dto.SubThemeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SubThemeService {

    Page<SubThemeDTO> findAllSubThemeByTheme(String themeId, Pageable pageable);
}
