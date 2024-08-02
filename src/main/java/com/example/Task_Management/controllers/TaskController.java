package com.example.Task_Management.controllers;

import com.example.Task_Management.dto.CountType;
import com.example.Task_Management.entities.Task;
import com.example.Task_Management.services.TaskService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class TaskController {

    private TaskService taskService;

    @GetMapping("/task")
    public List<Task> getTasks()
    {
        return taskService.getTasks();
    }

    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable Long id)
    {
        return taskService.getTaskById(id).
                orElseThrow
                        (
                                ()->new EntityNotFoundException("Requested task not found")
                        );
    }

    @GetMapping("/task/vData/percentCountType")
    List<CountType> getPercentageGroupByType()
    {
        return taskService.getPercentageGroupByType();
    }

    @PostMapping("/task")
    public Task addTask(@RequestBody Task task)
    {
        return taskService.save(task);

    }

    @PutMapping("task/{id}")
    public ResponseEntity<?> addTask(@RequestBody Task task, @PathVariable Long id)
    {
        if (taskService.existsById(id))
        {
            Task task1 = taskService.getTaskById(id).
                    orElseThrow(
                            ()->new EntityNotFoundException("Requested task not found")
                    );
            task1.setTitle(task.getTitle());
            task1.setDescription(task.getDescription());
            task1.setDueDate(task.getDueDate());
            task1.setType(task.getType());
            taskService.save(task);
            return ResponseEntity.ok().body(task1);
        }
        else
        {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", id + "task not found or matched");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    @DeleteMapping("task/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id)
    {
        if (taskService.existsById(id))
        {
            taskService.deleteTask(id);
            HashMap<String, String> message = new HashMap<>();
            message.put("message", "Task with id " + id + "deleted successfully.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", id + "task not found or matched");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

        }
    }
}

