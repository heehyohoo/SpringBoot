package com.example.jpacalendarpractice02.controller;

import com.example.jpacalendarpractice02.dto.ScheduleResponse;
import com.example.jpacalendarpractice02.service.ScheduleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class ScheduleControllerTest {

    private MockMvc mockMvc;


    @Mock
    HttpSession session;

    @Mock // 모조품을 하나 생성한다.  목객체를 컨트롤러에 주입시켜서 작동테스트를 한다.
    private ScheduleService scheduleService;
    @InjectMocks
    private ScheduleController scheduleController;

    @BeforeEach
    void setUp(@Autowired ScheduleController scheduleController) {
        //MockMvc
        mockMvc = MockMvcBuilders.standaloneSetup(scheduleController).build();
    }


    @Test
    @DisplayName("Schedule Controller Select Test")
    void scheduleSelectTest() {
        ScheduleResponse response = new ScheduleResponse("8","study","2023-01-10");
        List<ScheduleResponse> result = new ArrayList<>();
        result.add(response);

        //조건 : 무엇을 호출하면 무엇을 돌려준다.
        given(scheduleController.scheduleList(session)).willReturn(result);
        List<ScheduleResponse> testResult = scheduleController.scheduleList((session));
        Assertions.assertEquals("8",testResult.get(0).getId());
    }

    @Test
    @Transactional
    void scheduleDeleteTest() throws Exception {

        mockMvc.perform(delete("/schedules/26")) // 호출 URL
                .andExpect(status().isOk()) // 결과 200(정상) 호출이 되어야 함.
                .andExpect(content().string("success")) // 응답이 "success"로 나와야 함.\
                .andDo(print()); // 출력

    }

}