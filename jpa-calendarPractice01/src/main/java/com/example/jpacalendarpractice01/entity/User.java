package com.example.jpacalendarpractice01.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "schedule_user")
public class User {

    @Id
    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    @OrderBy("date DESC")
    private List<Schedule> schedules;


}
