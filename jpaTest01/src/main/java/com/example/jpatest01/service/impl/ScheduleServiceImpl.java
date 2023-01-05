package com.example.jpatest01.service.impl;

import com.example.jpatest01.dto.ScheduleRequest;
import com.example.jpatest01.dto.ScheduleResponse;
import com.example.jpatest01.entity.Schedule;
import com.example.jpatest01.entity.User;
import com.example.jpatest01.repository.ScheduleRepository;
import com.example.jpatest01.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public List<ScheduleResponse> scheduleList(String email) {

        return scheduleRepository.findByUser(User.builder()
                .email(email)
                .build()).stream()
                .map(ScheduleResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public String deleteSchedules(String id) {

        try {
            scheduleRepository.deleteById(Long.valueOf(id));

        }catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }

        return "success";
    }


    @Override
    public String insertSchedules(ScheduleRequest scheduleRequest) {


        try {
            scheduleRepository.save(scheduleRequest.toEntity());

        }catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }

        return "success";
    }
}
