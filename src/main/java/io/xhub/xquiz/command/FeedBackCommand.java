package io.xhub.xquiz.command;

import io.xhub.xquiz.core.Validatable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static io.xhub.xquiz.util.Assert.assertNotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FeedBackCommand implements Validatable {

    private String content;

    @Override
    public void validate() {
        assertNotBlank(content);
    }
}
