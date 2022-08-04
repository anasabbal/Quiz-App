package io.xhub.xquiz.dto;

import io.xhub.xquiz.enums.EventSetupType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EventSetupDTO {

    private String id;
    private String title;
    private String description;
    private EventSetupType kind;
    private String initializeButtonText;
    private EventFormSetupDTO formSetup;

}
