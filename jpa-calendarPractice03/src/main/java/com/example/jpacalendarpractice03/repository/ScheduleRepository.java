package com.example.jpacalendarpractice03.repository;

import com.example.jpacalendarpractice03.entity.Schedule;
import com.example.jpacalendarpractice03.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

    List<Schedule> findByUser(User user);

}
