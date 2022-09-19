package io.xhub.xquiz.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GoodyDTO {

    private String id;
    private String label;
    private Integer stock;
    private boolean isEligible;
}
