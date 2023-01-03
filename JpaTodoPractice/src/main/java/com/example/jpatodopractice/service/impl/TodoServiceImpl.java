package com.example.jpatodopractice.service.impl;


import com.example.jpatodopractice.dto.ResponseTodo;
import com.example.jpatodopractice.entity.Todo;
import com.example.jpatodopractice.repository.TodoRepository;
import com.example.jpatodopractice.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public List<ResponseTodo> todolist() {
        return todoRepository.findAll().stream()
                .map(ResponseTodo::new)
                .collect(Collectors.toList());
    }

    @Override
    public String deleteTodos(String id) {
        try {
            todoRepository.deleteById(Long.valueOf(id));
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";

    }

    @Override
    public String inserTodos(String todos) {
        try {
            todoRepository.save(Todo.builder()
                    .todos(todos)
                    .build());
        }catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }
}
