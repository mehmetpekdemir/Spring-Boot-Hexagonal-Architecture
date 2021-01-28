package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.taskversion.rest.dto.response;

import com.mehmetpekdemir.hexagonalarchitecture.domain.taskversion.model.TaskVersion;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.rest.dto.response.TaskResponse;
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
public final class TaskVersionResponse {

    private Long id;

    private Integer versionNumber;

    private String subject;

    private String description;

    public static TaskVersionResponse fromModel(final TaskVersion taskVersion) {
        return TaskVersionResponse.builder()
                .id(taskVersion.getId())
                .versionNumber(taskVersion.getVersionNumber())
                .subject(taskVersion.getSubject())
                .description(taskVersion.getDescription())
                .build();
    }

    public static List<TaskVersionResponse> fromListOfModel(final List<TaskVersion> taskVersions) {
        return taskVersions.stream().map(TaskVersionResponse::fromModel).collect(Collectors.toList());
    }

}
