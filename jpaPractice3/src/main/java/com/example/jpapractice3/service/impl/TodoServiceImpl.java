package com.example.jpapractice3.service.impl;

import com.example.jpapractice3.dto.ResponseDTO;
import com.example.jpapractice3.entity.Todo;
import com.example.jpapractice3.repository.TodoRepository;
import com.example.jpapractice3.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public List<ResponseDTO> todolist() {
        return todoRepository.findAll().stream()
                .map(ResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public String insertTodo(String todos) {
        try {
            todoRepository.save(Todo.builder()
                    .todos(todos)
                    .build());
        } catch (Exception e) {
//            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    @Override
    public String deleteTodo(String id) {

        try {
            todoRepository.deleteById(Long.valueOf(id));
        } catch (Exception e) {
            return "failed";
        }
        return "success";
    }
}
