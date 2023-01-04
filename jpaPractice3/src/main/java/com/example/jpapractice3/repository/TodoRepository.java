package com.example.jpapractice3.repository;

import com.example.jpapractice3.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
