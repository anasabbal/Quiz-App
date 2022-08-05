package io.xhub.xquiz.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventFormElementDTO {

    private String type;
    private String name;
    private String placeholder;
    private Boolean required;
    private String htmlType;

}
