package com.example.jpacalendarpractice02.service;

import com.example.jpacalendarpractice02.dto.ScheduleRequest;
import com.example.jpacalendarpractice02.dto.ScheduleResponse;

import java.util.List;

public interface ScheduleService {


    List<ScheduleResponse> scheduleList(String email);
    String insertSchedule(ScheduleRequest scheduleRequest);
    String deleteSchedule(String id);
}
