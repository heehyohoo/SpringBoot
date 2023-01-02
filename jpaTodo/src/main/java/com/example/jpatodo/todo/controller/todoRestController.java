package com.example.jpatodo.todo.controller;


import com.example.jpatodo.entity.Todolist;
import com.example.jpatodo.service.TodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class todoRestController {

    private TodolistService todolistService;
    @Autowired
    public todoRestController(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    @GetMapping("/receiveList")
    public void receiveList(Todolist todolist) {
        todolistService.receiveList(todolist);
    }

    @GetMapping("/list")
    public List<Todolist> SelectTodolist() {
        return todolistService.SelectTodolist();
    }
}
