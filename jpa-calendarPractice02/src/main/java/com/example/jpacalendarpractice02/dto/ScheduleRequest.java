package com.example.jpacalendarpractice02.dto;

import com.example.jpacalendarpractice02.entity.Schedule;
import com.example.jpacalendarpractice02.entity.User;
import lombok.*;

import javax.persistence.Table;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class ScheduleRequest {

    private String email;
    private Long id;
    private String title;
    private String date;


    public Schedule toEntity(ScheduleRequest scheduleRequest) {
        return Schedule.builder()
                .user(User.builder().email(email).build())
                .id(id)
                .title(title)
                .date(date).build();
    }

}
