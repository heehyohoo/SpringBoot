package com.example.jpacalendarpractice02.dto;

import com.example.jpacalendarpractice02.entity.User;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class UserRequest {

    private String email;
    private String password;


    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password).build();
    }

}
