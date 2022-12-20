package com.example.newfinalproject.chat.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;

@RestController
public class ChatController {

    static List<ArrayList<String>> msgList = new ArrayList<>();

    @GetMapping("/chat/getMsg")
    public List<ArrayList<String>> msg() {
        return msgList;
    }

    @GetMapping("/chat/sendMsg")
    public void receiveMsg(HttpSession session, String msg) {

        ArrayList<String> msgContent = new ArrayList<>();

        String nickName = String.valueOf(session.getAttribute("nickName"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = new Date();
        String timeStr = format.format(time);

        msgContent.add(nickName);
        msgContent.add(msg);
        msgContent.add(timeStr);

        msgList.add(msgContent);
    }
}
