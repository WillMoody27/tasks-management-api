package com.example.tasksmanagementapi.controller;

import com.example.tasksmanagementapi.service.TaskService;
import com.example.tasksmanagementapi.users.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TasksController {

//GET /api/tasks
//GET /api/tasks/{id}
//GET /api/tasks/user/{userId}
//GET /api/tasks/category/{categoryId}
//GET /api/tasks/due/{dueDate}
//POST /api/tasks
//PUT /api/tasks/{id}
//DELETE /api/tasks/{id}

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> task = taskService.getAllTasks();
        return ResponseEntity.ok(task);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getUserById(@PathVariable Long id) {
        Optional<Task> categoryOptional = taskService.getTasksById(id);
        return categoryOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

//    CREATE NEW TASK
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task savedTask = taskService.createTask(task);
        return ResponseEntity.ok(savedTask);
    }

//    UPDATE TASK
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Optional<Task> taskOptional = taskService.getTasksById(id);
        if (taskOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Task updatedTask = taskService.updateTask(id, task);
        return ResponseEntity.ok(updatedTask);
    }

    // DELETE TASK
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    // Additional endpoints
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Task>> findByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok().body(taskService.findByUserId(userId));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Task>> findByCategoryId(@PathVariable Long categoryId) {
        return ResponseEntity.ok().body(taskService.findByCategoryId(categoryId));
    }
}
