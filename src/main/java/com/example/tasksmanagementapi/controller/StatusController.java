package com.example.tasksmanagementapi.controller;

import com.example.tasksmanagementapi.service.StatusService;
import com.example.tasksmanagementapi.users.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    // Setup Controller to handle interactions with the StatusService and DB

    @Autowired
    private StatusService statusService;

    @GetMapping
    public ResponseEntity<List<Status>> getAllStatus() {
        List<Status> status = statusService.getAllStatus();
        return ResponseEntity.ok(status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status> getUserById(@PathVariable Long id) {
        Optional<Status> userOptional = statusService.getStatusById(id);
        return userOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Status> createStatus(@RequestBody Status status) {
        Status savedStatus = statusService.createStatus(status);
        return ResponseEntity.ok(savedStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Long id) {
        statusService.deleteStatus(id);
        return ResponseEntity.noContent().build();
    }
}
