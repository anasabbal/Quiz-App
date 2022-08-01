package io.xhub.xquiz.api;

import io.xhub.xquiz.dto.FileDTO;
import io.xhub.xquiz.dto.mapper.FileMapper;
import io.xhub.xquiz.service.file.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.xhub.xquiz.constants.ResourcePath.*;

@RestController
@RequestMapping(V1 + FILE_STORE)
@RequiredArgsConstructor
public class FileResource {
    private final FileMapper fileMapper;
    private final FileService fileService;

    @GetMapping("/{id}")
    public ResponseEntity<InputStreamResource> getFile(@PathVariable String id) {
        final FileDTO file = fileMapper.toFileDTO(fileService.getFile(id));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s", file.getFileName()))
                .contentType(MediaType.valueOf(file.getContentType()))
                .contentLength(file.getSize())
                .body(new InputStreamResource(file.getInputStream()));
    }
}
