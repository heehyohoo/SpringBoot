package com.example.jpacalendarpractice03.service.impl;

import com.example.jpacalendarpractice03.dto.RequestSchedule;
import com.example.jpacalendarpractice03.dto.ResponseSchedule;
import com.example.jpacalendarpractice03.repository.ScheduleRepository;
import com.example.jpacalendarpractice03.service.ScheduleService;
import entity.User;
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
                        .email(email).build()).stream() // 반환타입이 엔티티인 값을 가져와서 프론트에 내보낼 DTO로 바꾼후 내보낸다.
                .map(ResponseSchedule::new).collect(Collectors.toList());
    }

    @Override
    public String insertSchedule(RequestSchedule requestSchedule) {
        try {
            scheduleRepository.save(requestSchedule.toEntity()); // 엔티티로 변환하여 세이브 한다.
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
        }catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }
}
