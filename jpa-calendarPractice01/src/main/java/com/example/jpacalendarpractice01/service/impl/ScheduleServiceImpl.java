package com.example.jpacalendarpractice01.service.impl;

import com.example.jpacalendarpractice01.dto.RequestSchedule;
import com.example.jpacalendarpractice01.dto.ResponseSchedule;
import com.example.jpacalendarpractice01.entity.User;
import com.example.jpacalendarpractice01.repository.ScheduleRepository;
import com.example.jpacalendarpractice01.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public List<ResponseSchedule> scheduleList(String email) {

        return scheduleRepository.findByUser(User.builder()
                .email(email)
                .build()).stream()
                .map(ResponseSchedule::new)
                .collect(Collectors.toList());
    }

    @Override
    public String insertSchedule(RequestSchedule requestSchedule) {
        try {
            scheduleRepository.save(requestSchedule.toEntity());
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
