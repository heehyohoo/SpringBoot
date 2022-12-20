package com.example.chat.page.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ChatPageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/goMain")
    public String goMain(String nickName, HttpSession session) {
        session.setAttribute("nickName",nickName);
        return "main";
    }

}
