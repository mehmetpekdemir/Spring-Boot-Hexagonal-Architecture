package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.taskversion.jpa;

import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.taskversion.jpa.entity.TaskVersionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface TaskVersionJpaRepository extends JpaRepository<TaskVersionEntity, Long> {

    Optional<TaskVersionEntity> findByTaskIdAndVersionNumber(Long taskId, Integer versionNumber);

}
