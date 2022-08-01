package io.xhub.xquiz.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.InputStream;

@Getter
@Setter
public class FileDTO {
    private InputStream inputStream;
    private Long size;
    private String contentType;
    private String fileName;
}
