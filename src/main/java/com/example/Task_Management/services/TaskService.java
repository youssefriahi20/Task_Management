package com.example.Task_Management.services;

import com.example.Task_Management.dto.CountType;
import com.example.Task_Management.entities.Task;
import com.example.Task_Management.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;

    public List<Task> getTasks()
    {
        return taskRepository.getAllTaskByDueDate();
    }

    public Optional<Task> getTaskById(Long id)
    {
        return taskRepository.findById(id);
    }

    public Task save(Task task)
    {
        return taskRepository.saveAndFlush(task);
    }

    public boolean existsById(Long id)
    {
        return taskRepository.existsById(id);
    }

    public void deleteTask(Long id)
    {
        taskRepository.deleteById(id);
    }

    public List<CountType> getPercentageGroupByType()
    {
        return taskRepository.getPercentageGroupByType();

    }

}
