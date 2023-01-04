package com.example.jpatest01.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "schedule_user")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class User {


    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;            // JPA는 데이터베이스에서 1가지 정보만 가져오려고 해도 알아서 연관된 걸 다 가져오는 습성이 있음.
                                        // EAGER 즉시 가져오다., LAZY 알아서 가져오는걸 멈춘다.
    @OneToMany(fetch = FetchType.LAZY)  // 유저는 스케쥴을 여러개 가질수 있다.
    @OrderBy("date DESC")
    private List<Schedule> schedule;
}
