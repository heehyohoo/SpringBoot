package com.example.jpacalendarpractice03.dto;

import entity.Schedule;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class ResponseSchedule {

    private String id;
    private String title;
    private String date;


    public ResponseSchedule(Schedule schedule) {
        this.id = String.valueOf(schedule.getId());
        this.title = schedule.getTitle();
        this.date = schedule.getDate();
    }
}
