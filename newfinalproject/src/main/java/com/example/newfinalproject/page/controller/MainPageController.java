package com.example.newfinalproject.page.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;


@Controller
public class MainPageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/goSignUp")
    public String signup() {
        return "signup";
    }

    @GetMapping("/goLogin")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {

        if (session.getAttribute("email") != null) {
            session.setAttribute("email", null);
            model.addAttribute("message", "로그아웃 완료");
            model.addAttribute("url", "/");
            return "message";
        }

        if (session.getAttribute("email") == null) {
            model.addAttribute("message", "로그인 상태가 아닙니다.");
            model.addAttribute("url", "/");
        }
        return "message";
    }



}
