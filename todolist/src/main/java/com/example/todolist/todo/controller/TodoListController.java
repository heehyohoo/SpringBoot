package com.example.todolist.todo.controller;


import com.example.todolist.mapper.TodoListMapper;
import com.example.todolist.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TodoListController  {

    @Autowired
    TodoListService ts;


    @GetMapping("/list")
    public ArrayList<String> list() {
        return ts.selectAllTodo();
    }

    @GetMapping("/receiveList")
    public ArrayList<String> receivelist(String todo) {
        ts.insertTodo(todo);
        return ts.selectAllTodo();
    }

    @GetMapping("/deleteList")
    public ArrayList<String> deletelist(int todo) {
           ts.deleteTodo(todo);
        return list();
    }
}




