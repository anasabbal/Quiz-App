package io.xhub.xquiz.domain;


import lombok.*;

import javax.persistence.*;


@Table(name = "themes")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Theme extends BaseEntity{

    @Column(name = "LABEL")
    private String label;

    @Column(name = "ICON")
    private String icon;
}
