package com.mehmetpekdemir.hexagonalarchitecture.domain.taskversion;

import com.mehmetpekdemir.hexagonalarchitecture.domain.task.model.TaskCreate;
import com.mehmetpekdemir.hexagonalarchitecture.domain.taskversion.model.TaskVersion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class TaskVersionFacade {

    private final TaskVersionRepository taskVersionRepository;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public TaskVersion getTaskVersionByVersionNumber(final Long taskId, final Integer versionNumber) {
        return taskVersionRepository.getTaskVersionByVersionNumber(taskId, versionNumber);
    }

    @Transactional
    public TaskVersion createTaskVersion(final TaskCreate taskCreate, final Long taskId) {
        return taskVersionRepository.createTaskVersion(taskCreate, taskId);
    }

}
