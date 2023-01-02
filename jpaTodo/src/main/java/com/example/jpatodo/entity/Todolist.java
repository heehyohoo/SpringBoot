package com.example.jpatodo.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Todolist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Transient
    Integer id;

    String todo;

//    @Transient
    String indate;
}
