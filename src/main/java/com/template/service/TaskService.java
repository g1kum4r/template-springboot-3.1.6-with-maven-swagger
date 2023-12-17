package com.template.service;

import com.template.model.Task;
import com.template.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> fetchAll(){
        return this.taskRepository.findAll().stream().map(m -> new Task(
                m.getId(),
                m.getTitle(),
                m.getDescription()
        )).toList();
    }
}
