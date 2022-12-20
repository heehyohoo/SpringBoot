package com.example.newfinalproject.todo.controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    private List<String> todoList = new ArrayList<>();

    @GetMapping("/list")
    public List<String> viewList() {
        return todoList;
    }

    @GetMapping("receiveList")
    public List<String> receiveList(String todo, Model model) {

        for (String s : todoList) {
            if(s.equals(todo)) {
                return todoList;
            }
        }
        todoList.add(todo);
        return todoList;
    }

    @GetMapping("/deleteList")
    public List<String> deleteList(int todo) {
        todoList.remove(todo);
        return todoList;
    }

}
