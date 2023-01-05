package com.example.jpacalendarpractice02.service.impl;

import com.example.jpacalendarpractice02.dto.ScheduleRequest;
import com.example.jpacalendarpractice02.dto.ScheduleResponse;
import com.example.jpacalendarpractice02.entity.User;
import com.example.jpacalendarpractice02.repository.ScheduleRepository;
import com.example.jpacalendarpractice02.service.ScheduleService;
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
                .email(email).build()).stream()
                .map(ScheduleResponse::new).collect(Collectors.toList());
    }

    @Override
    public String insertSchedule(ScheduleRequest scheduleRequest) {
        try {
            scheduleRepository.save(scheduleRequest.toEntity());
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    @Override
    public String deleteSchedule(String id) {
        try {
            scheduleRepository.deleteById(Long.valueOf(id));
        } catch (Exception e) {
            return "failed";
        }
        return "success";
    }
}
