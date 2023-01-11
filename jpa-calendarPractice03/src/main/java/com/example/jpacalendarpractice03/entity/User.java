package com.example.jpacalendarpractice03.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "schedule_user")
@Getter
@Builder
@ToString
public class User {


    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany
    @OrderBy("date DESC")
    private List<Schedule> schedules;

}
