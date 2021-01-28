package com.mehmetpekdemir.hexagonalarchitecture.service;

import com.mehmetpekdemir.hexagonalarchitecture.domain.common.TaskBusinessException;
import com.mehmetpekdemir.hexagonalarchitecture.domain.task.TaskFacade;
import com.mehmetpekdemir.hexagonalarchitecture.domain.task.model.Task;
import com.mehmetpekdemir.hexagonalarchitecture.domain.task.model.TaskCreate;
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
@DisplayName("TaskUnitTests")
class TaskServiceTests {

    @Autowired
    private TaskFacade taskFacade;

    @Test
    void test_get_task_by_task_id_correct() {
        final Task expected = new Task();
        expected.setId(1L);
        expected.setName("Task Name 1");

        final Task actual = taskFacade.getTaskByTaskId(1L);

        assertEquals(expected, actual);
    }

    @Test
    void test_get_task_by_task_id_wrong() {
        assertThrows(TaskBusinessException.class, () -> taskFacade.getTaskByTaskId(4L));
    }

    @Test
    void test_successful_create_task() {
        final Task expected = new Task();
        expected.setId(2L);
        expected.setName("Task Name 1");
        expected.setVersionNumber(1);
        expected.setSubject("Subject 1");
        expected.setDescription("Description 1");

        final TaskCreate taskCreate = new TaskCreate();
        taskCreate.setName("Task Name 1");
        taskCreate.setVersionNumber(1);
        taskCreate.setSubject("Subject 1");
        taskCreate.setDescription("Description 1");

        final Task actual = taskFacade.createTask(taskCreate);

        assertEquals(expected, actual);
    }

}
