package io.xhub.xquiz.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EventThemeDTO {

    private String id;
    private Boolean active;
    private String backgroundImage;
    private String backgroundColor;
    private String primaryColor;
    private String secondaryColor;
    private String fontFamily;

}
