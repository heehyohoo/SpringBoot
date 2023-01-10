package com.example.jpacalendarpractice03.controller;

import com.example.jpacalendarpractice03.dto.RequestUser;
import com.example.jpacalendarpractice03.service.UserService;
import lombok.RequiredArgsConstructor;
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

    @PostMapping("/login") // 셀렉트 유저서비스를 실행한 결과값에 따라 success를 반환시 세션에 이메일을 등록한다.
    public String selectUser(RequestUser requestUser, HttpSession session) {
        String result = userService.selectUser(requestUser);

        if(result.equals("success")) {
            session.setAttribute("email",requestUser.getEmail());
        }
        return result;
    }
}
