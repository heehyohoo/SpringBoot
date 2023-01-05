package com.example.jpacalendarpractice02.repository;

import com.example.jpacalendarpractice02.dto.ScheduleResponse;
import com.example.jpacalendarpractice02.entity.Schedule;
import com.example.jpacalendarpractice02.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

    List<Schedule> findByUser(User user);
}
