package io.xhub.xquiz.dto.mapper;

import io.xhub.xquiz.domain.Event;
import io.xhub.xquiz.dto.EventDTO;
import io.xhub.xquiz.dto.EventDetailsDTO;
import org.mapstruct.*;

import java.time.LocalDate;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring", uses = {EventSetupMapper.class, EventThemeMapper.class})
public interface EventMapper {
    EventDTO toEventDTO(Event event);

    @Mapping(target = "eventDates", ignore = true)
    EventDetailsDTO toEventDetailsDTO(Event event);

    @AfterMapping
    default void eventDates(@MappingTarget EventDetailsDTO eventDetailsDTO, Event event) {
        final LocalDate startDate = event.getStartDate().toLocalDate();
        final LocalDate endDate = event.getEndDate().toLocalDate().plusDays(1);
        eventDetailsDTO.setEventDates(startDate.datesUntil(endDate)
                .collect(Collectors.toList())
        );
    }

}