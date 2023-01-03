package com.example.jpatodopractice.todo.controller;


import com.example.jpatodopractice.dto.ResponseTodo;
import com.example.jpatodopractice.service.TodoService;
import com.example.jpatodopractice.service.impl.TodoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoRestController {

    private final TodoService todoService;

    @GetMapping("/todos")
    public List<ResponseTodo> todoList() {
        return todoService.todolist();
    }

    @DeleteMapping("/todos/{id}")
    public String deleteTodos(@PathVariable String id) {
        return todoService.deleteTodos(id);
    }

    @PostMapping("/todos")
    public String inserTodos(String todos) {
        return todoService.inserTodos(todos);
    }

}
