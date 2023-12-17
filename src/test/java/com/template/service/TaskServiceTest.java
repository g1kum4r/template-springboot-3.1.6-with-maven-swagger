package com.template.service;

import com.template.entity.TaskEntity;
import com.template.model.Task;
import com.template.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @MockBean
    private TaskRepository taskRepository;

    @Test
    public void fetchAll(){
        List<TaskEntity> list = List.of(
                new TaskEntity(1L, "one", "description"),
                new TaskEntity(2L, "two", "description")
        );

        when(taskRepository.findAll()).thenReturn(list);
        List<Task> tasks = taskService.fetchAll();
        assertFalse(tasks.isEmpty());
        assertTrue(tasks.size() == list.size());
    }
}