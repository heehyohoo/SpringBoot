package com.example.todolist.repository;


import com.example.todolist.mapper.TodoListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class TodoListRepository {

    @Autowired
    TodoListMapper mapper;

    public int insertTodo(String todo) {
        return mapper.insertTodo(todo);
    }

    public ArrayList<String> selectAllTodo() {
        return mapper.selectAllTodo();
    }
    public int deleteTodo(int id) {
        return mapper.deleteTodo(id);
    }
}
