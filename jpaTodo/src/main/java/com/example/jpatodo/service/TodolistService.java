package com.example.jpatodo.service;


import com.example.jpatodo.dto.TodoReqDTO;
import com.example.jpatodo.dto.TodoResDTO;
import com.example.jpatodo.entity.Todolist;
import com.example.jpatodo.repository.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodolistService {

    private TodolistRepository todolistRepository;

    @Autowired
    public TodolistService(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    public void receiveList(TodoReqDTO todoReqDTO) {
        Todolist todolist = todoReqDTO.toEntity();
        todolistRepository.save(todolist);

    }

    public List<TodoResDTO> SelectTodolist() {
        List<Todolist> list = todolistRepository.findAll();

        List<TodoResDTO> result = list.stream()
                .map(todolist -> new TodoResDTO(todolist.getTodo()))
                .collect(Collectors.toList());
        return result;


    }




}
