package com.example.tasksmanagementapi.service;

import com.example.tasksmanagementapi.repository.TaskRepository;
import com.example.tasksmanagementapi.users.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTasksById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.saveAndFlush(task);
    }

    public List<Task> findByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    public List<Task> findByCategoryId(Long categoryId) {
        return taskRepository.findByCategoryId(categoryId);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(Long id, Task task) {
        task.setId(id);
        return taskRepository.save(task);
    }
}
