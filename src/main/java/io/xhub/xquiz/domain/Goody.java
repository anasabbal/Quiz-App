package io.xhub.xquiz.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "GOODIES")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Goody extends BaseEntity {

    @Column(name = "LABEL")
    private String label;
    @Column(name = "AVAILABLE_STOCK")
    private Integer availableStock;

    @Column(name = "WIN_SCORE_THRESHOLD")
    private int winScoreThreshold;
}