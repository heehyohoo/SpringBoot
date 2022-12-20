package com.example.finalproject.page.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/chat")
public class ChatPageController {

    @GetMapping("/")
    public String index() {
        return "/chat/index";
    }

    @GetMapping("/goMain")
    public String goMain(HttpSession session) {
        session.setAttribute("nickName",session.getAttribute("email"));
        return "/chat/main";
    }

}
