package com.example.jpapractice3.todo.controller;


import com.example.jpapractice3.dto.ResponseDTO;
import com.example.jpapractice3.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todos")
    public List<ResponseDTO> todolist() {
        return todoService.todolist();
    }


    @PostMapping("/todos")
    public String insertTodo(String todos) {
        return todoService.insertTodo(todos);
    }

    @DeleteMapping("/todos/{id}")
    public String deleteTodo(@PathVariable String id) {
        return todoService.deleteTodo(id);
    }


}
