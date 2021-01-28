package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.rest.dto.response;

import com.mehmetpekdemir.hexagonalarchitecture.domain.task.model.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class TaskResponse {

    private Long id;

    private String name;

    public static TaskResponse fromModel(final Task task) {
        return TaskResponse.builder()
                .id(task.getId())
                .name(task.getName())
                .build();
    }

    public static List<TaskResponse> fromListOfModel(final List<Task> tasks) {
        return tasks.stream().map(TaskResponse::fromModel).collect(Collectors.toList());
    }

}
