package com.mehmetpekdemir.hexagonalarchitecture.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@AutoConfigureMockMvc
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
@DisplayName("TaskVersionIntegrationTests")
class TaskVersionControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test_get_task_version_by_version_number_correct() throws Exception {
        final String content = "" +
                "{\n" +
                "    \"data\": {\n" +
                "        \"id\": 1,\n" +
                "        \"versionNumber\": 1,\n" +
                "        \"subject\": \"Subject 1\",\n" +
                "        \"description\": \"Description 1\"\n" +
                "    },\n" +
                "    \"errors\": null,\n" +
                "    \"time\": \"2021-01-29\"\n" +
                "}";

        mockMvc.perform(
                get("/api/task-version/1/version/1")
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().json(content)
        ).andDo(print());

    }

    @Test
    void test_get_task_version_by_version_number_wrong() throws Exception {
        final String content = "" +
                "{\n" +
                "    \"data\": null,\n" +
                "    \"errors\": {\n" +
                "        \"errorCode\": \"400\",\n" +
                "        \"errorDescription\": \"Version number not found !\"\n" +
                "    },\n" +
                "    \"time\": \"2021-01-29\"\n" +
                "}";


        mockMvc.perform(
                get("/api/task-version/1/version/2")
        ).andExpect(
                status().isBadRequest()
        ).andExpect(
                content().json(content)
        ).andDo(print());

    }


}
