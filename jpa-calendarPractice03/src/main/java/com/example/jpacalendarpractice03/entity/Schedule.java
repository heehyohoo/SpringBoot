package com.example.jpacalendarpractice03.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Schedule {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "date")
    private String date;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email")
    private User user;


}
