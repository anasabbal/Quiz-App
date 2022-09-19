package io.xhub.xquiz.repository;

import io.xhub.xquiz.domain.Goody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface GoodyRepository extends JpaRepository<Goody, String> {
    List<Goody> findAllByDeletedFalse();
    @Query("SELECT goody FROM Goody goody WHERE goody.id in (:goodiesIDS) and goody.deleted = false ")
    List<Goody> findAllByIDS(Set<String> goodiesIDS);

    Optional<Goody> findByIdAndDeletedFalse(String s);
}
