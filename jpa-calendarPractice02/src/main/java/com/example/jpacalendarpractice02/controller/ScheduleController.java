package com.example.jpacalendarpractice02.controller;


import com.example.jpacalendarpractice02.dto.ScheduleRequest;
import com.example.jpacalendarpractice02.dto.ScheduleResponse;
import com.example.jpacalendarpractice02.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/schedules")
    public List<ScheduleResponse> scheduleList(HttpSession session) {

        String email = String.valueOf(session.getAttribute("email"));
        return scheduleService.scheduleList(email);
    }

    @PostMapping("/schedules")
    public String insertSchedule(ScheduleRequest scheduleRequest,HttpSession session) {
        String email = String.valueOf(session.getAttribute("email"));
        scheduleRequest.setEmail(email);
        return scheduleService.insertSchedule(scheduleRequest);
    }

    @DeleteMapping("/schedules/{id}")
    public String deleteSchedule(@PathVariable("id") String id) {
        return scheduleService.deleteSchedule(id);
    }

}
