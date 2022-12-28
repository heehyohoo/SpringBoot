package com.example.jpapractice.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="Example")
public class Example {

    @Id
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private int price;

}
