package com.example.jpacalendarpractice03.repository;

import entity.Schedule;
import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

    List<Schedule> findByUser(User user);

}
