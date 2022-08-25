package io.xhub.xquiz.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PassMarkDTO {
    private Integer passMark;
    private Float scorePercentage;

    public static PassMarkDTO create(Integer passMark, Float scorePercentage) {
        PassMarkDTO passMarkDTO = new PassMarkDTO();
        passMarkDTO.setPassMark(passMark);
        passMarkDTO.setScorePercentage(scorePercentage);
        return passMarkDTO;
    }
}
