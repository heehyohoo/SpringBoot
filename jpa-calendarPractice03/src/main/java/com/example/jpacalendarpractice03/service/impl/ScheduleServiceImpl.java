package com.example.jpacalendarpractice03.service.impl;

import com.example.jpacalendarpractice03.dto.RequestSchedule;
import com.example.jpacalendarpractice03.dto.ResponseSchedule;
import com.example.jpacalendarpractice03.service.ScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {


    @Override
    public List<ResponseSchedule> scheduleList(String email) {
        return null;
    }

    @Override
    public String insertSchedule(RequestSchedule requestSchedule) {
        return null;
    }

    @Override
    public String deleteSchedule(String id) {
        return null;
    }
}
