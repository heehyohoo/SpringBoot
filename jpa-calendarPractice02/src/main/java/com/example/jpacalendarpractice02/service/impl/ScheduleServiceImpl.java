package com.example.jpacalendarpractice02.service.impl;

import com.example.jpacalendarpractice02.dto.ScheduleRequest;
import com.example.jpacalendarpractice02.dto.ScheduleResponse;
import com.example.jpacalendarpractice02.service.ScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Override
    public List<ScheduleResponse> scheduleList(String email) {
        return null;
    }

    @Override
    public String insertSchedule(ScheduleRequest scheduleRequest) {
        return null;
    }

    @Override
    public String deleteSchedule(String id) {
        return null;
    }
}
