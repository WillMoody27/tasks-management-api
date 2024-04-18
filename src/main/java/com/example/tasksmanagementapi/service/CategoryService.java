package com.example.tasksmanagementapi.service;

import com.example.tasksmanagementapi.repository.CategoryRepository;
import com.example.tasksmanagementapi.repository.UserRepository;
import com.example.tasksmanagementapi.users.Category;
import com.example.tasksmanagementapi.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoriesById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
