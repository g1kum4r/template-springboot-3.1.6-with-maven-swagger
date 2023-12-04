package com.template.controller;

import com.template.model.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class TaskController {

    @GetMapping
    public List<Task> fetchAll(){
        return List.of(new Task(UUID.randomUUID(), UUID.randomUUID().toString()));
    }
}
