package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.SubTheme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubThemeRepository extends JpaRepository<SubTheme, String> {
    Page<SubTheme> findAllSubThemeByThemeId(String themeId, Pageable pageable);
    List<SubTheme> findAllByThemeId(String themeId);
}
