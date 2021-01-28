package com.mehmetpekdemir.hexagonalarchitecture.domain.task;

import com.mehmetpekdemir.hexagonalarchitecture.domain.task.model.Task;
import com.mehmetpekdemir.hexagonalarchitecture.domain.task.model.TaskCreate;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface TaskRepository {

    Task getTaskByTaskId(final Long taskId);

    Task createTask(final TaskCreate taskCreate);

}
