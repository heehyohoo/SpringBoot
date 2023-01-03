package com.example.jpatodosangsu.dto;


import com.example.jpatodosangsu.entity.Todo;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TodoResDTO {

    private String id;
    private String todos;

    public TodoResDTO(Todo todo) {
        this.id = String.valueOf(todo.getId());
        this.todos = todo.getTodos();
    }

}
