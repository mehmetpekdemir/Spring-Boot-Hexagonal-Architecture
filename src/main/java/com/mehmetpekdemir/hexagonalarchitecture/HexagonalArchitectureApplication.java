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
            taskJpaRepository.save(new TaskEntity("Task Name 1","Task Description 1"));
            taskJpaRepository.save(new TaskEntity("Task Name 2","Task Description 2"));
            taskJpaRepository.save(new TaskEntity("Task Name 3","Task Description 3"));
        };
    }

}
