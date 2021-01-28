package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.jpa;

import com.mehmetpekdemir.hexagonalarchitecture.domain.common.TaskBusinessException;
import com.mehmetpekdemir.hexagonalarchitecture.domain.task.TaskRepository;
import com.mehmetpekdemir.hexagonalarchitecture.domain.task.model.Task;
import com.mehmetpekdemir.hexagonalarchitecture.domain.task.model.TaskCreate;
import com.mehmetpekdemir.hexagonalarchitecture.domain.taskversion.TaskVersionFacade;
import com.mehmetpekdemir.hexagonalarchitecture.domain.taskversion.model.TaskVersion;
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
    private final TaskVersionFacade taskVersionFacade;

    @Override
    public Task getTaskByTaskId(final Long taskId) {
        return toModel(getTaskById(taskId));
    }

    @Override
    public Task createTask(final TaskCreate taskCreate) {
        var savedTask = saveTask(taskCreate);
        var savedTaskVersion = taskVersionFacade.createTaskVersion(taskCreate, savedTask.getId());
        return toModel(savedTask, savedTaskVersion);
    }

    private TaskEntity getTaskById(final Long taskId) {
        return taskJpaRepository.findById(taskId)
                .orElseThrow(() -> new TaskBusinessException("task.not.found"));
    }

    private TaskEntity saveTask(final TaskCreate taskCreate) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setName(taskCreate.getName());
        return taskJpaRepository.save(taskEntity);
    }

    private Task toModel(final TaskEntity taskEntity) {
        return Task.builder()
                .id(taskEntity.getId())
                .name(taskEntity.getName())
                .build();
    }

    private Task toModel(final TaskEntity taskEntity, final TaskVersion taskVersion) {
        return Task.builder()
                .id(taskEntity.getId())
                .name(taskEntity.getName())
                .versionNumber(taskVersion.getVersionNumber())
                .subject(taskVersion.getSubject())
                .description(taskVersion.getDescription())
                .build();
    }

}
