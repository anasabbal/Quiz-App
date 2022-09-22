package io.xhub.xquiz.domain;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "sub_themes")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SubTheme extends BaseEntity{



    @Column(name = "TITLE")
    private String title;

    @Column(name = "ICON")
    private String icon;

    @Column(name = "PERCENTAGE")
    private Integer percentage;

    @ManyToOne
    private Theme theme;

    @OneToMany(mappedBy = "subTheme", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Question> questions;
}
