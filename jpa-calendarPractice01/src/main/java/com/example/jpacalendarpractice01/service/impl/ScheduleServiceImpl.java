package com.example.jpacalendarpractice01.service.impl;

import com.example.jpacalendarpractice01.dto.RequestSchedule;
import com.example.jpacalendarpractice01.dto.ResponseSchedule;
import com.example.jpacalendarpractice01.service.ScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Override
    public List<ResponseSchedule> ScheduleList(String email) {
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
