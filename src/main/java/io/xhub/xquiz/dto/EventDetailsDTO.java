package io.xhub.xquiz.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDetailsDTO {
    private String id;
    private String name;
    private String logo;
    private List<LocalDate> eventDates;
    private List<EventSetupDTO> setup;
    private Boolean active;
    private Boolean initialized;
    private List<EventThemeDTO> themes;

}
