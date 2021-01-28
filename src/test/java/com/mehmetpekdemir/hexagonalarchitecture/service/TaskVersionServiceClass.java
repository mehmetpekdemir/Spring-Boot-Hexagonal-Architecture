package com.mehmetpekdemir.hexagonalarchitecture.service;

import com.mehmetpekdemir.hexagonalarchitecture.domain.common.TaskBusinessException;

import com.mehmetpekdemir.hexagonalarchitecture.domain.taskversion.TaskVersionFacade;
import com.mehmetpekdemir.hexagonalarchitecture.domain.taskversion.model.TaskVersion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@SpringBootTest
@DisplayName("TaskVersionUnitTests")
class TaskVersionServiceClass {

    @Autowired
    private TaskVersionFacade taskVersionFacade;

    @Test
    void test_get_task_version_by_version_number_correct() {
        final TaskVersion expected = new TaskVersion();

        expected.setId(1L);
        expected.setVersionNumber(1);
        expected.setSubject("Subject 1");
        expected.setDescription("Description 1");

        final TaskVersion actual = taskVersionFacade.getTaskVersionByVersionNumber(1L, 1);

        assertEquals(expected, actual);
    }

    @Test
    void test_get_task_version_by_version_number_wrong() {
        assertThrows(TaskBusinessException.class, () -> taskVersionFacade.getTaskVersionByVersionNumber(1L, 2));
    }

}
