package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.rest;

import com.mehmetpekdemir.hexagonalarchitecture.domain.task.TaskFacade;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.rest.dto.request.TaskCreateRequest;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.rest.dto.response.TaskResponse;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.common.annotation.ApiController;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.common.rest.BaseController;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.common.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

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

    @PostMapping("task")
    public Response<?> createTask(@RequestBody @Valid final TaskCreateRequest taskCreateRequest) {
        final var task = taskFacade.createTask(taskCreateRequest.toModel());
        return respond(TaskResponse.fromModel(task));
    }

}
