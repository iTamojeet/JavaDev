package com.example.controller;

import com.example.dto.TaskDto;
import com.example.entity.Task;
import com.example.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDto> createATask(@RequestBody TaskDto taskDto){
        return new ResponseEntity<>(taskService.createTask(taskDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskDto> getAnyTask(@PathVariable Long id){
        return ResponseEntity.ok(taskService.getATask(id));
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getTasks(){
        return ResponseEntity.ok(taskService.getAll());
    }

    @PutMapping("{id}")
    public ResponseEntity<TaskDto> updated(@PathVariable Long id,@RequestBody TaskDto taskDto){
        return ResponseEntity.ok(taskService.updateTask(id, taskDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleted(@PathVariable Long id){
        return ResponseEntity.ok(taskService.deleteTask(id));
    }

    @PatchMapping("{id}/complete")
    public ResponseEntity<TaskDto> completed(@PathVariable Long id){
        TaskDto completed = taskService.completeTask(id);
        return ResponseEntity.ok(completed);
    }
}
