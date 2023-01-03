package com.example.jpatodosangsu.repository;
import com.example.jpatodosangsu.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {

}
