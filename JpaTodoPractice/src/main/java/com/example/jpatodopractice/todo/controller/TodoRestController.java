package com.example.jpatodopractice.todo.controller;


import com.example.jpatodopractice.dto.ResponseTodo;
import com.example.jpatodopractice.service.impl.TodoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoRestController {

    private final TodoServiceImpl todoService;

    @GetMapping("/todos")
    public List<ResponseTodo> todoList() {
        return todoService.todolist();
    }

    @DeleteMapping("/todos/{id}")
    public String deleteTodos(String id) {
        return todoService.deleteTodos(id);
    }

    @PostMapping("/todos")
    public String inserTodos(String todos) {
        return todoService.inserTodos(todos);
    }

}
