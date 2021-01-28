package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.taskversion.jpa.entity;

import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.jpa.entity.TaskEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "task_version")
public class TaskVersionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "version_number", nullable = false)
    private Integer versionNumber;

    @Column(name = "subject", nullable = false, length = 50)
    private String subject;

    @Column(name = "description", nullable = false, length = 400)
    private String description;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private TaskEntity task;

}
