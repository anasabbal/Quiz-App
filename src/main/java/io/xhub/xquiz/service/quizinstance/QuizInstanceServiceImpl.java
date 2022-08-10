package io.xhub.xquiz.service.quizinstance;


import io.xhub.xquiz.domain.QuizInstance;
import io.xhub.xquiz.dto.QuizInstructionDTO;
import io.xhub.xquiz.dto.mapper.QuizInstructionMapper;
import io.xhub.xquiz.enums.Status;
import io.xhub.xquiz.exception.BusinessException;
import io.xhub.xquiz.exception.ExceptionPayloadFactory;
import io.xhub.xquiz.repository.QuizInstanceRepository;
import io.xhub.xquiz.repository.QuizInstructionRepository;
import io.xhub.xquiz.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class QuizInstanceServiceImpl implements QuizInstanceService{
    private final QuizInstanceRepository quizInstanceRepository;
    private final QuizInstructionRepository quizInstructionRepository;
    private final QuizInstructionMapper quizInstructionMapper;



    @Override
    public QuizInstance findById(String quizInstanceId) {
        log.info("Begin fetching quiz instance with id {}", quizInstanceId);
        final QuizInstance quizInstance = quizInstanceRepository.findById(quizInstanceId)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.QUIZ_INSTANCE_NOT_FOUND.get()));

        return quizInstance;
    }
    @Override
    public void updateStatus(String quizInstanceId){
        final QuizInstance quizInstance = findById(quizInstanceId);

        Status status = quizInstance.getCurrentStatus();

        if(Status.PENDING.equals(status)){
            quizInstance.updateStatusToClosed();
        }
        log.info("Status of Quiz instance with id {} updated successfully and payload is {}", quizInstanceId, JSONUtil.toJSON(quizInstance));

        quizInstanceRepository.save(quizInstance);
    }
    public List<QuizInstructionDTO> getQuizInstructions(){
        return quizInstructionMapper.dtoList(quizInstructionRepository.findAllQuizInstructionByDeletedFalse());
    }
}
