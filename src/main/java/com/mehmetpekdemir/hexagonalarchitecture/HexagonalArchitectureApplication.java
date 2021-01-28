package com.mehmetpekdemir.hexagonalarchitecture;

import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.jpa.TaskJpaRepository;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.jpa.entity.TaskEntity;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.taskversion.jpa.TaskVersionJpaRepository;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.taskversion.jpa.entity.TaskVersionEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@SpringBootApplication
public class HexagonalArchitectureApplication {

    public static void main(String[] args) {
        SpringApplication.run(HexagonalArchitectureApplication.class, args);
    }

    @Bean
    CommandLineRunner createInitialData(TaskJpaRepository taskJpaRepository, TaskVersionJpaRepository taskVersionJpaRepository) {
        return (args) -> {
            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setName("Task Name 1");
            taskJpaRepository.save(taskEntity);

            TaskVersionEntity taskVersionEntity = new TaskVersionEntity();
            taskVersionEntity.setSubject("Subject 1");
            taskVersionEntity.setVersionNumber(1);
            taskVersionEntity.setDescription("Description 1");
            taskVersionEntity.setTask(taskEntity);

            taskVersionJpaRepository.save(taskVersionEntity);

        };
    }

}
