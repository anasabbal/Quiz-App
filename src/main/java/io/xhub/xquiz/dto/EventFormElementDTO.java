package io.xhub.xquiz.dto;

import lombok.*;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(NON_NULL)
public class EventFormElementDTO {

    private String id;
    private String type;
    private String name;
    private String label;
    private String placeholder;
    private Boolean required;
    private String innerText;
    private String htmlType;

}
