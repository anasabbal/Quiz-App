package io.xhub.xquiz.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDTO {

    private String id;
    private String name;
    private Boolean active;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String logo;
    private Boolean initialized;
    private List<EventSetupDTO> setup;
    private List<EventThemeDTO> themes;
}
