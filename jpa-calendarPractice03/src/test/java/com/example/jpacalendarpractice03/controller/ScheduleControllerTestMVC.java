package com.example.jpacalendarpractice03.controller;

import com.example.jpacalendarpractice03.controller.ScheduleController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ScheduleControllerTestMVC {

    private MockMvc mockMvc; // 디펜던시 추가해야 사용가능

    // @BeforeEach 해당메서드가 현재 클래스의 테스트 메서드가 실행되기 전에 한번씩 무조건 먼저 호출이 됨.
    // @BeforeEach 에서 주로 하는일은 세션에 미리 값을 넣어놓는다거나, 어떤 객체를 생성해 둔다거나 미리 준비할것들
    @BeforeEach
    void setUp(@Autowired ScheduleController scheduleController) { // 일종의 설정파일이라고 보면됨.
        // 빌더를 통해 MockMvc 객체를 생성.
        mockMvc = MockMvcBuilders.standaloneSetup(scheduleController).build();
    }

    @Test
    @Transactional  // 테스트에서 트랜젝셔널 어노테이션은 롤백을 의미
    void scheduleDeleteTest() throws Exception {
        //테스트 메서드
        // @DeleteMapping("/schedules/{id}")
        // public String deleteSchedule(@PathVariable("id") String id) {

        mockMvc.perform(delete("/schedules/3")) //호출 url
                .andExpect(status().isOk()) //결과 200(정상) 호출이 되어야함
                .andExpect(content().string("success")) //응답이 "success"로 나와야함
                .andDo(print()); //출력
    }

}