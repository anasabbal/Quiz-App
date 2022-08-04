package io.xhub.xquiz.dto;

import io.xhub.xquiz.enums.FormElementType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EventFormElementDTO {

    private FormElementType type;
    private String name;
    private String placeholder;
    private Boolean required;
    private String htmlType;

}
