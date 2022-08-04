package io.xhub.xquiz.dto;

import io.xhub.xquiz.enums.SubmitMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class EventFormSetupDTO {

    private String formName;
    private String formTitle;
    private String submitUrl;
    private SubmitMethod submitMethod;
    private List<EventFormElementDTO> elements;

}
