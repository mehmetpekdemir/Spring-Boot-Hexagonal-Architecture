package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.taskversion.rest;

import com.mehmetpekdemir.hexagonalarchitecture.domain.taskversion.TaskVersionFacade;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.taskversion.rest.dto.response.TaskVersionResponse;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.common.annotation.ApiController;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.common.rest.BaseController;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.common.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@ApiController
@RequiredArgsConstructor
public class TaskVersionController extends BaseController {

    private final TaskVersionFacade taskVersionFacade;

    @GetMapping("task-version/{taskId}/version/{versionNumber}")
    public Response<?> getTaskVersionByVersionNumber(
            @PathVariable(value = "taskId") final Long taskId,
            @PathVariable(value = "versionNumber") final Integer versionNumber) {

        final var taskVersion = taskVersionFacade.getTaskVersionByVersionNumber(taskId, versionNumber);
        return respond(TaskVersionResponse.fromModel(taskVersion));
    }

}
