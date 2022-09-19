package io.xhub.xquiz.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
@Builder
public class ParticipantDetailsCountDTO {

   @JsonUnwrapped
   private Page<ParticipantDetailsDTO> participantPage;
   private int count;
}
