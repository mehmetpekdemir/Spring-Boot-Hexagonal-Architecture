package com.mehmetpekdemir.hexagonalarchitecture.domain.task;

import com.mehmetpekdemir.hexagonalarchitecture.domain.task.model.Task;
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
public class TaskFacade {

    private final TaskRepository taskRepository;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Task getTaskByTaskId(final Long taskId) {
        return taskRepository.getTaskByTaskId(taskId);
    }

}
