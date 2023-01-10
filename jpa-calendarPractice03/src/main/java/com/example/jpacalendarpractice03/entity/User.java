package com.example.jpacalendarpractice03.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "schedule_user")
@Getter
@Builder
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
