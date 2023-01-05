package com.example.jpacalendarpractice01.dto;

import com.example.jpacalendarpractice01.entity.Schedule;
import com.example.jpacalendarpractice01.entity.User;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class RequestSchedule {

    private String email;
    private String title;
    private String date;


    public Schedule toEntity() {
        return Schedule.builder()
                .user(User.builder().email(email).build())
                .title(title)
                .date(date)
                .build();
    }


}
