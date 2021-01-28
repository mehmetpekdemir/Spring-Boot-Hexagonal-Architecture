package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.jpa.entity;

import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.taskversion.jpa.entity.TaskVersionEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_name", nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "task")
    private List<TaskVersionEntity> taskVersions = new ArrayList<>();

}
