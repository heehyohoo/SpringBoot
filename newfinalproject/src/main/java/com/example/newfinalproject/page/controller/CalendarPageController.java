package com.example.newfinalproject.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CalendarPageController {

    @GetMapping("/calendar")
    public String index(HttpSession session, Model model) {
        if(session.getAttribute("email") != null){
            return "/calendar/calendarIndex";
        }
        model.addAttribute("message", "로그인 회원만 접근 가능합니다.");
        model.addAttribute("url", "/");
        return "message";

    }
}
