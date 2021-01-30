package com.mehmetpekdemir.hexagonalarchitecture;

import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.jpa.TaskJpaRepository;
import com.mehmetpekdemir.hexagonalarchitecture.infrastructure.adapters.task.jpa.entity.TaskEntity;
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
    CommandLineRunner createInitialData(TaskJpaRepository taskJpaRepository) {
        return (args) -> {
            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setName("Task Name 1");
            taskEntity.setSubject("Test Subject 1");
            taskEntity.setDescription("Test Description 1");
            taskJpaRepository.save(taskEntity);
        };
    }

}
