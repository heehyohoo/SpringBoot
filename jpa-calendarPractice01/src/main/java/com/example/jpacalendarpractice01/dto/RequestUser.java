package com.example.jpacalendarpractice01.dto;


import com.example.jpacalendarpractice01.entity.User;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class RequestUser {

    private String email;
    private String password;

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .build();
    }

}
