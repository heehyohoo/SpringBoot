package com.example.jpacalendarpractice02.repository;

import com.example.jpacalendarpractice02.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
}
