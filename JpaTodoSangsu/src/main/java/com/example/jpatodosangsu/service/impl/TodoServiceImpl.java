package com.example.jpatodosangsu.service.impl;
import com.example.jpatodosangsu.dto.TodoResDTO;
import com.example.jpatodosangsu.repository.TodoRepository;
import com.example.jpatodosangsu.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    @Override
    public List<TodoResDTO> todolist() {
        return null;
    }

    @Override
    public String deleteTodos(String id) {
        return null;
    }

    @Override
    public String insertTodos(String todos) {
        return null;
    }
}
