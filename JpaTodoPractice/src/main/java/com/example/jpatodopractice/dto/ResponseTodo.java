package com.example.jpatodopractice.dto;


import com.example.jpatodopractice.entity.Todo;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseTodo {

    private String id;
    private String todos;
    private String indate;

    public ResponseTodo(Todo todo) {
        this.id = String.valueOf(todo.getId());
        this.todos = todo.getTodos();
        this.indate = todo.getIndate();
    }
}
