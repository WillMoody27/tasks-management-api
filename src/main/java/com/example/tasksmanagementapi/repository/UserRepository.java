package com.example.tasksmanagementapi.repository;

import com.example.tasksmanagementapi.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}