package com.example.jpacalendarpractice01.service;

import com.example.jpacalendarpractice01.dto.RequestSchedule;
import com.example.jpacalendarpractice01.dto.ResponseSchedule;

import java.util.List;

public interface ScheduleService {

    List<ResponseSchedule> scheduleList(String email);

    String insertSchedule(RequestSchedule requestSchedule);

    String deleteSchedule(String id);
}
