package com.example.todolist.service;


import com.example.todolist.mapper.TodoListMapper;
import com.example.todolist.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class TodoListService {

    @Autowired
    TodoListRepository tr;

    public int insertTodo(String todo) {
        return tr.insertTodo(todo);
    }

    public ArrayList<String> selectAllTodo() {
        return tr.selectAllTodo();
    }

    public int deleteTodo(int id) {
        return tr.deleteTodo(id);
    }
}
