package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.rest.dto.response;

import com.mehmetpekdemir.hexagonalarchitecture.domain.task.model.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String subject;

    private String description;

    public static TaskResponse fromModel(final Task task) {
        return TaskResponse.builder()
                .id(task.getId())
                .name(task.getName())
                .subject(task.getSubject())
                .description(task.getDescription())
                .build();
    }

}
