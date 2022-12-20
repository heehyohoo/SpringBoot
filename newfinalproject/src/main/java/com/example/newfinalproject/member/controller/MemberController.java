package com.example.newfinalproject.member.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Controller
public class MemberController {

    private List<HashMap<String, String>> memberList = new ArrayList<>();

    @PostMapping("/signup")
    public String addMember(@RequestParam HashMap<String, String> params, Model model) {

        memberList.add(params);
        model.addAttribute("message", "회원 가입 성공");
        model.addAttribute("url", "/");
        return "message";
    }

    @PostMapping("/login")
    public String doLogin(String email, String password, Model model, HttpSession session) {

        if (memberList.isEmpty()) {
            model.addAttribute("message", "일치하는 회원이 없습니다.");
            model.addAttribute("url", "/");
            return "message";
        }

        for (HashMap<String, String> map : memberList) {

            if (map.get("email").equals(email) && map.get("password").equals(password)) {
                session.setAttribute("email", email);
                model.addAttribute("message", "로그인 성공");
                model.addAttribute("url", "/");
            } else {
                model.addAttribute("message", "일치하는 회원이 없습니다.");
                model.addAttribute("url", "/goLogin");
            }
        }
        return "message";
    }
}
