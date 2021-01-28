package com.mehmetpekdemir.hexagonalarchitecture.domain.taskversion;

import com.mehmetpekdemir.hexagonalarchitecture.domain.task.model.TaskCreate;
import com.mehmetpekdemir.hexagonalarchitecture.domain.taskversion.model.TaskVersion;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface TaskVersionRepository {

    TaskVersion getTaskVersionByVersionNumber(final Long taskId, final Integer versionNumber);

    TaskVersion createTaskVersion(final TaskCreate taskCreate, final Long taskId);

}
