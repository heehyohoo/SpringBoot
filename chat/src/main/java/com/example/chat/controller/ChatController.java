package com.example.chat.controller;

import org.apache.tomcat.util.http.ConcurrentDateFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ChatController {

    static List<ArrayList<String>> msgList = new ArrayList<>();

    @GetMapping("/chat/getMsg")
    public List<ArrayList<String>> Msg() {
        return msgList;
    }

    @GetMapping("/chat/sendMsg")
    public void ReseiveMsg(HttpSession session,String msg) {

        ArrayList<String> msgContent = new ArrayList<>();
        Date time = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = format1.format(time);
        String nickName = String.valueOf(session.getAttribute("nickName"));

        msgContent.add(nickName);
        msgContent.add(msg);
        msgContent.add(timeStr);

        msgList.add(msgContent);

    }
}
