package io.xhub.xquiz.dto;

import io.xhub.xquiz.enums.EventSetupType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventSetupDTO {

    private String id;
    private String title;
    private String description;
    private EventSetupType kind;
    private String initializeButtonText;
    private EventFormSetupDTO formSetup;

}
