package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.jpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 
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

	@Column(name = "description", nullable = false, length = 400)
	private String description;

	public TaskEntity(String name, String description) {
		this.name = name;
		this.description = description;
	}

}
