package com.example.jpacalendarpractice03.service;

import com.example.jpacalendarpractice03.dto.RequestSchedule;
import com.example.jpacalendarpractice03.dto.ResponseSchedule;

import java.util.List;

public interface ScheduleService {

    //스케쥴 목록 가져오기 유저의 email을 기준으로 스케쥴을 가져와야 하기 때문에 email이 매개변수가 되어야 한다.
    List<ResponseSchedule> scheduleList(String email);

    //스케쥴 등록 성공하면 success , 실패하면 failed 를 리턴이므로 반환타입은 String
    String insertSchedule(RequestSchedule requestSchedule);

    //스케쥴 삭제 성공하면 success , 실패하면 failed 를 리턴이므로 반환타입은 String
    String deleteSchedule(String id);



}
