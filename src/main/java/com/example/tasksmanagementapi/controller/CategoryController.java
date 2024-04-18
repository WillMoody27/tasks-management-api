package com.example.tasksmanagementapi.controller;

import com.example.tasksmanagementapi.service.CategoryService;
import com.example.tasksmanagementapi.service.StatusService;
import com.example.tasksmanagementapi.users.Category;
import com.example.tasksmanagementapi.users.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

//    Interact with Category DB through CategoryService

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllStatus() {
        List<Category> category = categoryService.getAllCategories();
        return ResponseEntity.ok(category);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getUserById(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.getCategoriesById(id);
        return categoryOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.createCategory(category);
        return ResponseEntity.ok(savedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
