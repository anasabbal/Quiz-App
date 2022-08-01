package io.xhub.xquiz.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity(name = "File")
@Getter
@Setter
public class File extends BaseEntity {
    @Column(name = "file_name")
    private String fileName;

    @Column(name = "CONTENT_TYPE")
    private String contentType;

    @Column(name = "EXTENSION")
    private String extension;

    @Column(name = "SIZE")
    private long size;

    @Lob
    @Column(name = "CONTENT")
    private byte[] content;
}
