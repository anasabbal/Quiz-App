package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {

    @Query(value = "select *  from questions  q  where q.seniority_level_id = :seniorityLevelId and q.sub_theme_id = :subThemeId and q.deleted = false order by random() limit :totalQuestion", nativeQuery = true)
    List<Question> findListQuestionBySeniorityLevelIdAndSubThemeId(String seniorityLevelId, String subThemeId, Integer totalQuestion);
}