package io.xhub.xquiz.dto.mapper;

import io.xhub.xquiz.domain.Attendee;
import io.xhub.xquiz.dto.AttendeeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public abstract class AttendeeMapper {

    public abstract AttendeeDTO toAttendeeDTO(Attendee attendee);
}
