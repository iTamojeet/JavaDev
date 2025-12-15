package com.example.service;

import com.example.dto.TaskDto;

import java.util.List;

public interface TaskService {
    TaskDto createTask(TaskDto taskDto);
    TaskDto getATask(Long id);
    List<TaskDto> getAll();
    TaskDto updateTask(Long id, TaskDto taskDto);
    String deleteTask(Long id);
    TaskDto completeTask(Long id);
}
