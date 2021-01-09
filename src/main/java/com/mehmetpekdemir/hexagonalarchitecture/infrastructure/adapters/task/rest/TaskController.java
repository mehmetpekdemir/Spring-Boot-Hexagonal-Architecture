package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.rest;

import com.mehmetpekdemir.hexagonalarchitecture.domain.task.TaskFacade;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.rest.dto.response.TaskResponse;
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
public class TaskController extends BaseController {

    private final TaskFacade taskFacade;

    @GetMapping("task/{taskId}")
    public Response<?> getTaskByTaskId(@PathVariable(value = "taskId") final Long taskId) {
        final var task = taskFacade.getTaskByTaskId(taskId);
        return respond(TaskResponse.fromModel(task));
    }

}
