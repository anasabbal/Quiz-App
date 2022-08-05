package io.xhub.xquiz.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
