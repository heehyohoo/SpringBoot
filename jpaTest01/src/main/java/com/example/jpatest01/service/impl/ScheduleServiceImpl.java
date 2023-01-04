package com.example.jpatest01.service.impl;

import com.example.jpatest01.dto.ScheduleRequest;
import com.example.jpatest01.dto.ScheduleResponse;
import com.example.jpatest01.repository.ScheduleRepository;
import com.example.jpatest01.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public List<ScheduleResponse> scheduleList(String email) {
        return null;
    }

    @Override
    public String deleteSchedules(String id) {
        return null;
    }

    @Override
    public String insertSchedules(ScheduleRequest scheduleRequest) {
        return null;
    }
}
