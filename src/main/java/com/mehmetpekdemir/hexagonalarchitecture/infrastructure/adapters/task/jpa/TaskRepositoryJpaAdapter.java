package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.jpa;

import com.mehmetpekdemir.hexagonalarchitecture.domain.common.TaskBusinessException;
import com.mehmetpekdemir.hexagonalarchitecture.domain.task.TaskRepository;
import com.mehmetpekdemir.hexagonalarchitecture.domain.task.model.Task;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.jpa.entity.TaskEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class TaskRepositoryJpaAdapter implements TaskRepository {

	private final TaskJpaRepository taskJpaRepository;

	@Override
	public Task getTaskByTaskId(final Long taskId) {
		final TaskEntity taskEntity = taskJpaRepository.findById(taskId)
				.orElseThrow(() -> new TaskBusinessException("task.not.found"));
		return toModel(taskEntity);
	}

	private Task toModel(final TaskEntity taskEntity) {
		return Task.builder() //
				.id(taskEntity.getId()) //
				.name(taskEntity.getName()) //
				.description(taskEntity.getDescription()) //
				.build(); //
	}

}
