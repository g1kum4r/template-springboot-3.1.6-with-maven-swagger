package com.template.controller;

import com.template.model.Task;
import com.template.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Test
    void fetchAll() throws Exception {
        List<Task> list = List.of(
                new Task(1L, "one", "description"),
                new Task(2L, "two", "description")
        );
        when(taskService.fetchAll()).thenReturn(list);
        this.mockMvc
                .perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id").exists())
                .andExpect(jsonPath("$[*].title").exists())
                .andExpect(jsonPath("$[*].description").exists())
                .andExpect(jsonPath("$[0].id").value(list.get(0).getId()))
                .andExpect(jsonPath("$[0].title").value(list.get(0).getTitle()))
                .andExpect(jsonPath("$[0].description").value(list.get(0).getDescription()));
    }
}