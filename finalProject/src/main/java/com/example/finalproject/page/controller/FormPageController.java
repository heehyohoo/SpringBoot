package com.example.finalproject.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class FormPageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/goSignUp")
    public String goSignUp() {
        return "signup";
    }

    @GetMapping("/goLogin")
    public String goLogin(HttpSession session, Model model) {

        if (session.getAttribute("email") != null) {
            model.addAttribute("message", "현재 로그인 상태 입니다.");
            model.addAttribute("url", "/");
            return "message";
        }

        return "login";
    }

    @GetMapping("/goChat")
    public String goChat(HttpSession session, Model model) {
        if (session.getAttribute("email") != null) {
            model.addAttribute("message", "현재 로그인 상태 입니다. 채팅창으로 이동합니다.");
            model.addAttribute("url", "/chat/goMain");
            return "message";
        }

        model.addAttribute("message", "로그인을 해주세요.");
        model.addAttribute("url", "/goLogin");
        return "message";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {

        if(session.getAttribute("email") != null) {
            session.setAttribute("email", null);
            model.addAttribute("message", "로그아웃 완료");
            model.addAttribute("url", "/");
            return "message";
        }
        model.addAttribute("message", "로그인 상태가 아닙니다.");
        model.addAttribute("url", "/");
        return "message";
    }


}
