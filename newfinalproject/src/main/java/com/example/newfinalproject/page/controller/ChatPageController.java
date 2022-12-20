package com.example.newfinalproject.page.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ChatPageController {

    @GetMapping("/chat")
    public String chatMain(HttpSession session, Model model) {

        if(session.getAttribute("email") != null){
            session.setAttribute("nickName" , session.getAttribute("email"));
            return "/chat/chatMain";
        }
        model.addAttribute("message", "로그인 회원만 접근 가능합니다.");
        model.addAttribute("url", "/");
        return "message";

    }

    @GetMapping("/goMain")
    public String chatMain(String nickName,HttpSession session) {
        session.setAttribute("nickName" , nickName);
        return "/chat/chatMain";
    }

}
