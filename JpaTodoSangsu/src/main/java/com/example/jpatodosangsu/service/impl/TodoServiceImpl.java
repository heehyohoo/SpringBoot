package com.example.jpatodosangsu.service.impl;
import com.example.jpatodosangsu.dto.TodoResDTO;
import com.example.jpatodosangsu.entity.Todo;
import com.example.jpatodosangsu.repository.TodoRepository;
import com.example.jpatodosangsu.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    @Override
    public List<TodoResDTO> todolist() {
        return todoRepository.findAll().stream()
                .map(TodoResDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public String deleteTodos(String id) {
        try {
            todoRepository.deleteById(Long.valueOf(id));
        }catch (Exception e) {
//            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    @Override
    public String insertTodos(String todos) {

        try {
            todoRepository.save(Todo.builder()
                    .todos(todos)
                    .build());
        }catch (Exception e) {
//            e.printStackTrace();
            return "failed";
        }
        return "success";
    }
}
