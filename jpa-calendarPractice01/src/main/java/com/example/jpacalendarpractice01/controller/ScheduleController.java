package com.example.jpacalendarpractice01.controller;

import com.example.jpacalendarpractice01.dto.RequestSchedule;
import com.example.jpacalendarpractice01.dto.ResponseSchedule;
import com.example.jpacalendarpractice01.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/schedules")
    public List<ResponseSchedule> ScheduleList(HttpSession session) {
        String email = String.valueOf(session.getAttribute("email"));
        return scheduleService.ScheduleList(email);
    }

    @PostMapping("/schedules")
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
