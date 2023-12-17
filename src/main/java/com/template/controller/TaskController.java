package com.template.controller;

import com.template.service.TaskService;
import com.template.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> fetchAll(){
        return taskService.fetchAll();
    }
}
