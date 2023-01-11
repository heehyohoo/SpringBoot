package com.example.jpacalendarpractice03.page.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/goLogin")
    public String goLogin() {
        return "login";
    }

    @GetMapping("/goSignUp")
    public String goSignUp() {
        return "signup";
    }

    @GetMapping("/goCalendar")
    public String goCalendar() {
        return "calendar";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {

        session.setAttribute("email",null);
        model.addAttribute("message","로그아웃 성공");
        model.addAttribute("url","/");

        return "message";
    }
}
