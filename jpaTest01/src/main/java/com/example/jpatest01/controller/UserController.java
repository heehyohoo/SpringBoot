package com.example.jpatest01.controller;

import com.example.jpatest01.dto.UserRequest;
import com.example.jpatest01.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public String insertUser(UserRequest userRequest) {
        return userService.insertUser(userRequest);
    }

    @PostMapping("/login")
    public String login(UserRequest userRequest, HttpSession session) {
        String user = userService.selectUser(userRequest);
        if(user.equals("success")) {
            session.setAttribute("email",userRequest.getEmail());
        }
        return user;
    }




}
