package com.example.jpatodopractice.repository;

import com.example.jpatodopractice.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
