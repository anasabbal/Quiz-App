package io.xhub.xquiz.service.file;

import io.xhub.xquiz.domain.File;
import io.xhub.xquiz.exception.BusinessException;
import io.xhub.xquiz.exception.ExceptionPayloadFactory;
import io.xhub.xquiz.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileServiceImp implements FileService {
    private final FileRepository fileRepository;

    @Override
    @Transactional(readOnly = true)
    public File getFile(String id) {
        log.info("Start retrieving file with id '{}'", id);
        return fileRepository.findById(id).orElseThrow(() -> {
            log.error("No such file with id '{}'", id);
            return new BusinessException(ExceptionPayloadFactory.FILE_NOT_FOUND.get());
        });
    }
}
