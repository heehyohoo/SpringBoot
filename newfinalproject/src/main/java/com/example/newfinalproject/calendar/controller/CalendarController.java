package com.example.newfinalproject.calendar.controller;
import com.example.newfinalproject.dto.Calendar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CalendarController {

    private List<Calendar> calendarList = new ArrayList<>();

    @GetMapping("/all/schedule")
    public List<Calendar> veiwSchedule() {
        return calendarList;
    }

    @GetMapping("/put/schedule")
    public List<Calendar> putSchedule(Calendar calendar) {

        for (Calendar schedule : calendarList) {
            if((schedule.getDate().equals(calendar.getDate())&&schedule.getTitle().equals(calendar.getTitle()))){
                return calendarList;
            }
        }

        calendarList.add(calendar);
        return calendarList;
    }
}
