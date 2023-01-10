package com.example.jpacalendarpractice03.dto;

import com.example.jpacalendarpractice03.entity.Schedule;
import com.example.jpacalendarpractice03.entity.User;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestSchedule {

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
