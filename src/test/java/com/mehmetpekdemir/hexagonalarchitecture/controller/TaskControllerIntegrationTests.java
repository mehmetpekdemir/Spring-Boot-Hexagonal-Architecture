package com.mehmetpekdemir.hexagonalarchitecture.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@AutoConfigureMockMvc
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
@DisplayName("TaskIntegrationTests")
class TaskControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test_get_task_by_task_id_correct() throws Exception {
        final String content = "" +
                "{\n" +
                "                    \"data\": {\n" +
                "                        \"id\": 1,\n" +
                "                        \"name\": \"Task Name 1\"" +
                "                    },\n" +
                "                    \"errors\": null,\n" +
                "                    \"time\": \"2021-01-29\"\n" +
                "                }";

        mockMvc.perform(
                get("/api/task/1")
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().json(content)
        ).andDo(print());

    }

    @Test
    void test_get_task_by_task_id_wrong() throws Exception {
        final String content = "" +
                "{\n" +
                "                    \"data\": null,\n" +
                "                    \"errors\": {\n" +
                "                        \"errorCode\": \"400\",\n" +
                "                        \"errorDescription\": \"Task not found ! \"\n" +
                "                    },\n" +
                "                    \"time\": \"2021-01-29\"\n" +
                "                }";


        mockMvc.perform(
                get("/api/task/4")
        ).andExpect(
                status().isBadRequest()
        ).andExpect(
                content().json(content)
        ).andDo(print());

    }

    @Test
    void test_successful_create_task() throws Exception {
        final String bodyContent = "" +
                "{\n" +
                "\t\"name\":\"Test Task Name\",\n" +
                "\t\"versionNumber\":1,\n" +
                "    \"subject\":\"Test subject\",\n" +
                "    \"description\":\"Test description\"\n" +
                "}";

        final String responseContent = "" +
                "{\n" +
                "    \"data\": {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"Test Task Name\"\n" +
                "    },\n" +
                "    \"errors\": null,\n" +
                "    \"time\": \"2021-01-29\"\n" +
                "}";


        mockMvc.perform(
                post("/api/task")
                        .content(bodyContent)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().json(responseContent)
        ).andDo(print());
    }

}
