package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.rest.dto.request;

import com.mehmetpekdemir.hexagonalarchitecture.domain.task.model.TaskCreate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskCreateRequest {

    @NotNull(message = "{backend.constraint.taskName.NotNull.message}")
    @Size(min = 4, max = 50, message = "{backend.constraint.taskName.Size.message}")
    private String name;

    @NotNull(message = "{backend.constraint.versionNumber.NotNull.message}")
    @Positive(message = "{backend.constraint.versionNumber.Positive.message}")
    private Integer versionNumber;

    @NotNull(message = "{backend.constraint.subject.NotNull.message}")
    @Size(min = 4, max = 50, message = "{backend.constraint.subject.Size.message}")
    private String subject;

    @NotNull(message = "{backend.constraint.description.NotNull.message}")
    @Size(min = 4, max = 400, message = "{backend.constraint.description.Size.message}")
    private String description;

    public TaskCreate toModel() {
        return TaskCreate.builder()
                .name(name)
                .versionNumber(versionNumber)
                .subject(subject)
                .description(description)
                .build();
    }

}
