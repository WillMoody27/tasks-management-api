package com.example.tasksmanagementapi.repository;

import com.example.tasksmanagementapi.users.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}