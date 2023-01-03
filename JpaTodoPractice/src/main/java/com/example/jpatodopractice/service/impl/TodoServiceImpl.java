package com.example.jpatodopractice.service.impl;


import com.example.jpatodopractice.dto.ResponseTodo;
import com.example.jpatodopractice.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Override
    public List<ResponseTodo> todolist() {
        return null;
    }

    @Override
    public String deleteTodos(String id) {
        return null;
    }

    @Override
    public String inserTodos(String todos) {
        return null;
    }
}
