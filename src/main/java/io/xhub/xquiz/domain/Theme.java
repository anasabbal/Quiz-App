package io.xhub.xquiz.domain;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Table(name = "themes")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Theme extends BaseEntity{

    @Column(name = "LABEL")
    private String label;


    @OneToMany(mappedBy = "theme", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SubTheme> subThemes;

}
