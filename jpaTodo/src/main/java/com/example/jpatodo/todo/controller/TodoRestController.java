package com.example.jpatodo.todo.controller;


import com.example.jpatodo.dto.TodoReqDTO;
import com.example.jpatodo.dto.TodoResDTO;
import com.example.jpatodo.service.TodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoRestController {

    private TodolistService todolistService;
    @Autowired
    public TodoRestController(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    @GetMapping("/receiveList")
    public void receiveList(TodoReqDTO todoReqDTO) {
        todolistService.receiveList(todoReqDTO);
    }

    @GetMapping("/list")
    public List<TodoResDTO> SelectTodolist() {
        return todolistService.SelectTodolist();
    }
}
