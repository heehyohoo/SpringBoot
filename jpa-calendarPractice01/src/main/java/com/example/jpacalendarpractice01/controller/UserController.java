package com.example.jpacalendarpractice01.controller;


import com.example.jpacalendarpractice01.dto.RequestUser;
import com.example.jpacalendarpractice01.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public String insertUser(RequestUser requestUser) {
        return userService.insertUser(requestUser);
    }

    @PostMapping("/login")
    public String selectUser(RequestUser requestUser, HttpSession session) {
        String user = userService.selectUser(requestUser);

        if(user.equals("success")) {
            session.setAttribute("email", requestUser.getEmail());
        }
        return user;
    }

}
