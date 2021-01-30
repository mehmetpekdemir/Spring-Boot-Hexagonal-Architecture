package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.jpa;

import com.mehmetpekdemir.hexagonalarchitecture.domain.common.TaskBusinessException;
import com.mehmetpekdemir.hexagonalarchitecture.domain.task.TaskRepository;
import com.mehmetpekdemir.hexagonalarchitecture.domain.task.model.Task;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.jpa.entity.TaskEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class TaskRepositoryJpaAdapter implements TaskRepository {

    private final TaskJpaRepository taskJpaRepository;

    @Override
    public Task getTaskByTaskId(final Long taskId) {
        return toModel(getTaskById(taskId));
    }

    private TaskEntity getTaskById(final Long taskId) {
        return taskJpaRepository.findById(taskId)
                .orElseThrow(() -> new TaskBusinessException("task.not.found"));
    }

    private Task toModel(final TaskEntity taskEntity) {
        return Task.builder()
                .id(taskEntity.getId())
                .name(taskEntity.getName())
                .subject(taskEntity.getSubject())
                .description(taskEntity.getDescription())
                .build();
    }

}
