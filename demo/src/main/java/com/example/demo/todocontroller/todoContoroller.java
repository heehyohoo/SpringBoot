package com.example.demo.todocontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;


@RestController // JSON Ajax 방식으로 화면을 가져간다.
public class todoContoroller {

    private ArrayList<String> todoList = new ArrayList<>();

    @GetMapping("/list")
    public ArrayList<String> list() {
        return todoList;

    }

    @GetMapping("/receiveList")
    public ArrayList<String> receiveList(String todo) {
        Iterator<String> it = list().iterator();
        while (it.hasNext()) {
            if (it.next().equals(todo)) {
                return todoList;
            }
        }
        todoList.add(todo);

        return todoList;
    }

    @GetMapping("deleteList")
    public ArrayList<String> deleteList(int todo) {
        todoList.remove(todo);
        return todoList;
    }

}
