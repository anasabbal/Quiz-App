package io.xhub.xquiz.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Table(name = "seniority_levels")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SeniorityLevel extends BaseEntity{

    @Column(name = "LABEL")
    private String label;

    @OneToMany(mappedBy = "seniorityLevel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Question> questions;
}

