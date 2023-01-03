package com.example.jpatodo.dto;


import com.example.jpatodo.entity.Todolist;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TodoReqDTO {


    private String todo;
    private Long id;
    private String indate;


    public Todolist toEntity() {
        return Todolist.builder()
                .id(id)
                .todo(todo)
                .indate(indate)
                .build();
    }
}
