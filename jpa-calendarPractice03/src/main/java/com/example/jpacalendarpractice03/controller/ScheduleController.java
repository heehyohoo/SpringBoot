package com.example.jpacalendarpractice03.controller;

import com.example.jpacalendarpractice03.dto.RequestSchedule;
import com.example.jpacalendarpractice03.dto.ResponseSchedule;
import com.example.jpacalendarpractice03.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;


    @GetMapping("/schedules") // 로그인이 되었다면 세션에 이메일이 존재 할것이므로 세션에서 이메일을 가져와서 넘긴다.
    public List<ResponseSchedule> scheduleList(HttpSession session) {
        String email = String.valueOf(session.getAttribute("email"));
        return scheduleService.scheduleList(email);
    }
    @PostMapping("/schedules") // 스케쥴을 입력하려면 email이 필요하다.
    public String insertSchedule(RequestSchedule requestSchedule,HttpSession session) {
        String email = String.valueOf(session.getAttribute("email"));
        requestSchedule.setEmail(email);
        return scheduleService.insertSchedule(requestSchedule);
    }

    @DeleteMapping("/schedules/{id}")
    public String deleteSchedule(@PathVariable("id") String id) {
        return scheduleService.deleteSchedule(id);
    }


}
