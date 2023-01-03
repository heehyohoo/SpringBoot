package com.example.jpatodosangsu.todo.controller;


import com.example.jpatodosangsu.dto.TodoResDTO;
import com.example.jpatodosangsu.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class TodoRestController {

    private final TodoService todoService;

    @GetMapping("/todos")
    public List<TodoResDTO> todolists() {
        return todoService.todolist();
    }

    @DeleteMapping("/todos/{id}")
    public String deleteTodos(@PathVariable("id") String id) {
        return todoService.deleteTodos(id);
    }

    @PostMapping("/todos")
    public String insertTodos(String todos) {
        return todoService.insertTodos(todos);
    }
}
