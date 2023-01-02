package com.example.jpatodo.service;


import com.example.jpatodo.entity.Todolist;
import com.example.jpatodo.repository.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodolistService {

    private TodolistRepository todolistRepository;

    @Autowired
    public TodolistService(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    public void receiveList(Todolist todolist) {
        todolistRepository.save(todolist);
    }

    public List<Todolist> SelectTodolist() {
        return todolistRepository.findAll();
    }




}
