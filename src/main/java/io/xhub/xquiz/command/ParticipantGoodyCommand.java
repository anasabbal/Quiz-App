package io.xhub.xquiz.command;

import io.xhub.xquiz.core.Validatable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static io.xhub.xquiz.util.Assert.assertNotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantGoodyCommand implements Validatable {

    private String goodyID;
    
    @Override
    public void validate() {
        assertNotNull(goodyID);
    }
}
