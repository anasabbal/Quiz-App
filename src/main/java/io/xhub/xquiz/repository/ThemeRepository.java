package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ThemeRepository extends JpaRepository<Theme, String> {
    List<Theme> findAllByDeletedFalse();
}
