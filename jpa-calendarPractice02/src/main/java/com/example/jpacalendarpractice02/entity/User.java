package com.example.jpacalendarpractice02.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "schedule_user")
public class User {


    @Id
    @Column
    private String email;

    @Column
    private String password;

    @OneToMany
    @OrderBy("date DESC")
    private List<Schedule> schedules;

}
