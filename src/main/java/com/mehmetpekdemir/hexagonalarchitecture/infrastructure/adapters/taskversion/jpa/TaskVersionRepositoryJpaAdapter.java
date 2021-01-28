package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.taskversion.jpa;

import com.mehmetpekdemir.hexagonalarchitecture.domain.common.TaskBusinessException;
import com.mehmetpekdemir.hexagonalarchitecture.domain.task.model.TaskCreate;
import com.mehmetpekdemir.hexagonalarchitecture.domain.taskversion.TaskVersionRepository;

import com.mehmetpekdemir.hexagonalarchitecture.domain.taskversion.model.TaskVersion;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.jpa.TaskJpaRepository;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.jpa.entity.TaskEntity;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.taskversion.jpa.entity.TaskVersionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class TaskVersionRepositoryJpaAdapter implements TaskVersionRepository {

    private final TaskVersionJpaRepository taskVersionJpaRepository;
    private final TaskJpaRepository taskJpaRepository;

    @Override
    public TaskVersion getTaskVersionByVersionNumber(final Long taskId, final Integer versionNumber) {
        return toModel(getByTaskIdAndVersionNumber(taskId, versionNumber));
    }

    @Override
    public TaskVersion createTaskVersion(TaskCreate taskCreate, Long taskId) {
        return toModel(taskVersionJpaRepository.save(toEntity(taskCreate, taskId)));
    }

    private TaskVersionEntity getByTaskIdAndVersionNumber(Long taskId, Integer versionNumber) {
        return taskVersionJpaRepository.findByTaskIdAndVersionNumber(taskId, versionNumber)
                .orElseThrow(() -> new TaskBusinessException("version.number.not.found"));
    }

    private TaskEntity findTaskByTaskId(Long taskId) {
        return taskJpaRepository.findById(taskId)
                .orElseThrow(() -> new TaskBusinessException("task.not.found"));
    }

    private TaskVersionEntity toEntity(TaskCreate taskCreate, Long taskId) {
        TaskVersionEntity taskVersionEntity = new TaskVersionEntity();
        taskVersionEntity.setTask(findTaskByTaskId(taskId));
        taskVersionEntity.setSubject(taskCreate.getSubject());
        taskVersionEntity.setVersionNumber(taskCreate.getVersionNumber());
        taskVersionEntity.setDescription(taskCreate.getDescription());
        return taskVersionEntity;
    }

    private TaskVersion toModel(TaskVersionEntity taskVersionEntity) {
        return TaskVersion.builder()
                .id(taskVersionEntity.getId())
                .versionNumber(taskVersionEntity.getVersionNumber())
                .subject(taskVersionEntity.getSubject())
                .description(taskVersionEntity.getDescription())
                .build();
    }

}
