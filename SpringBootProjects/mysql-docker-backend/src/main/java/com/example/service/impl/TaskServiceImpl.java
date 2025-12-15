package com.example.service.impl;

import com.example.dto.TaskDto;
import com.example.entity.Task;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.TaskRepository;
import com.example.service.TaskService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    @Override
    public TaskDto createTask(TaskDto taskDto) {
//        return taskRepository.save(task);
        return modelMapper.map(taskRepository.save(
                modelMapper.map(taskDto, Task.class)),TaskDto.class);
    }

    @Override
    public TaskDto getATask(Long id) {
        return modelMapper.map(taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Dhur paini re...")),
                TaskDto.class);
    }

    @Override
    public List<TaskDto> getAll(){
        return taskRepository.findAll()
                .stream()
                .map((x)-> new TaskDto(x.getId(),x.getTitle(),x.getDescription(),x.isCompleted()))
                .toList();
    }

    @Override
    public TaskDto updateTask(Long id, TaskDto taskDto) {
        Task t=taskRepository.findById(id).get();
        t.setTitle(taskDto.getTitle());
        t.setDescription(taskDto.getDescription());
        t.setCompleted(taskDto.isCompleted());
        return modelMapper.map(taskRepository.save(t), TaskDto.class);
    }

    @Override
    public String deleteTask(Long id) {
        taskRepository.deleteById(id);
        return "the task with id "+id+" has been deleted!!!";
    }

    @Override
    public TaskDto completeTask(Long id) {
        Task task = taskRepository.findById(id).get();

        task.setCompleted(Boolean.TRUE);
        return null;
    }
}
