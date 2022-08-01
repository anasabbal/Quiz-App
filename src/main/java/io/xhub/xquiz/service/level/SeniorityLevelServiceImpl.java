package io.xhub.xquiz.service.level;


import io.xhub.xquiz.domain.SeniorityLevel;
import io.xhub.xquiz.repository.SeniorityLevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SeniorityLevelServiceImpl implements SeniorityLevelService {

    private final SeniorityLevelRepository seniorityLevelRepository;

    @Override
    @Transactional(readOnly = true)
    public List<SeniorityLevel> getSeniorityLevels() {
        return seniorityLevelRepository.findAllByDeletedFalse();
    }
}
