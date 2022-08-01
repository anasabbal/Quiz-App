package io.xhub.xquiz.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EventDTO {
    private String name;
    private String logoId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private String coverImageId;
    private String primaryColor;
    private String secondaryColor;
}
