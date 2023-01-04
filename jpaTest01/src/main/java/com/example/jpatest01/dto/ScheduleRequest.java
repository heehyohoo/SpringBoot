package com.example.jpatest01.dto;


import com.example.jpatest01.entity.Schedule;
import com.example.jpatest01.entity.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class ScheduleRequest {

    private String email; //등록자
    private String title; // 스케쥴 이름
    private String date; // 스케쥴 일지


    public Schedule toEntity() {
        return Schedule.builder()
                .user(User.builder().email(email).build())
                .title(title)
                .date(date).build();
    }

}
