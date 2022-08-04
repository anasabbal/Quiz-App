package io.xhub.xquiz.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Getter
@RequiredArgsConstructor
public class CreateEventSessionCommand {
    private final String eventId;
    private final String eventSetupId;

    private final Map<String, Object> payload;
}
