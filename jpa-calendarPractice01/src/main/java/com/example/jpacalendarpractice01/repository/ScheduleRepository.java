package com.example.jpacalendarpractice01.repository;

import com.example.jpacalendarpractice01.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
}
