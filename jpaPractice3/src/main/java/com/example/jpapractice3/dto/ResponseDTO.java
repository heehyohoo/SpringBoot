package com.example.jpapractice3.dto;


import com.example.jpapractice3.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ResponseDTO {

    private Long id;
    private String todos;
    private String indate;

    public ResponseDTO(Todo todo) {
        this.id = todo.getId();
        this.todos = todo.getTodos();
        this.indate = todo.getIndate();
    }
}
