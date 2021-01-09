package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.jpa;

import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.jpa.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface TaskJpaRepository extends JpaRepository<TaskEntity, Long> {

}
