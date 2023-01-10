package com.example.jpacalendarpractice03.dto;

import entity.Schedule;
import entity.User;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResquestSchedule {

    private String email;
    private Long id;
    private String title;
    private String date;

    public Schedule toEntity() {
        return Schedule.builder()
                .user(User.builder().email(email).build())
                .id(id)
                .title(title)
                .date(date)
                .build();
    }


}
