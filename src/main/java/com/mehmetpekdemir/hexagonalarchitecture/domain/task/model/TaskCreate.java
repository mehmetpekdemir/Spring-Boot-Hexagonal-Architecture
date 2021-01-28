package com.mehmetpekdemir.hexagonalarchitecture.domain.task.model;

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
public class TaskCreate {

    private String name;

    private Integer versionNumber;

    private String subject;

    private String description;

}
