package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.rest;

import com.mehmetpekdemir.hexagonalarchitecture.domain.task.TaskFacade;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.rest.dto.response.TaskResponse;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.common.rest.BaseController;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.common.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RestController
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
public class TaskController extends BaseController {

    private final TaskFacade taskFacade;

    @GetMapping("{taskId}")
    public Response<?> getTaskByTaskId(@PathVariable(value = "taskId") final Long taskId) {
        final var task = taskFacade.getTaskByTaskId(taskId);
        return respond(TaskResponse.fromModel(task));
    }

}
