package com.example.jpatest01.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Schedule {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)         // 스케쥴은 하나의 유저만 가질수 있고, 유저는 여러 스케쥴을 가질수있다.
    @JoinColumn(name = "email")
    private User user;

}
