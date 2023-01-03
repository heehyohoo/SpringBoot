package com.example.jpatodo.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Todolist {

    @Id
    private Long id;

    private String todo;
    private String indate;

}
