package com.example.jpacalendarpractice03.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ScheduleControllerTestMVC {

    //<MockMvc를 활용한 외부 테스트

    private MockMvc mockMvc; // 디펜던시 추가해야 사용가능
    protected MockHttpSession session; // 세션이 필요할경우 가짜 세션을 만들수 있다.

    // @BeforeEach 해당메서드가 현재 클래스의 테스트 메서드가 실행되기 전에 한번씩 무조건 먼저 호출이 됨.
    // @BeforeEach 에서 주로 하는일은 세션에 미리 값을 넣어놓는다거나, 어떤 객체를 생성해 둔다거나 미리 준비할것들
    @BeforeEach
    void setUp(@Autowired ScheduleController scheduleController) { // 일종의 설정파일이라고 보면됨.
        // 빌더를 통해 MockMvc 객체를 생성.
        mockMvc = MockMvcBuilders.standaloneSetup(scheduleController).build();    // 모든 테스트를 하기전 실행한다. mockMVC 객체를 만든다.
        session = new MockHttpSession();  // 새로운 MockHttpSession 객체를 생성하고
        session.setAttribute("email","1"); // 세션에 email 을 저장한다.
                                                       // 로그인 성공했을대 세션에 값을 넣는것을 여기서도 동일하게
    }

    @Test
    @DisplayName("델레트 테스트")
    @Transactional  // 테스트에서 트랜젝셔널 어노테이션은 롤백을 의미 이 어노테이션이 없다면 테스트후 DB에 데이터가 삭제되 버리고 있다면 삭제헀다가 다시 원상복구한다.
    void scheduleDeleteTest() throws Exception {
        //테스트 메서드
        // @DeleteMapping("/schedules/{id}")
        // public String deleteSchedule(@PathVariable("id") String id) {

        mockMvc.perform(delete("/schedules/4")) //호출 url   perform 다음에 오는 delete는 맵핑이름이다.
                .andExpect(status().isOk()) //결과 200(정상) 호출이 되어야함
                .andExpect(content().string("success")) //응답이 "success"로 나와야함
                .andDo(print()); //출력
    }

    @Test
    @DisplayName("셀렉트 테스트")
    @Transactional  // 테스트에서 트랜젝셔널 어노테이션은 롤백을 의미 이 어노테이션이 없다면 테스트후 DB에 데이터가 삭제되 버리고 있다면 삭제헀다가 다시 원상복구한다.
    void scheduleSelectTest() throws Exception {
     //테스트 메서드 <세션이 필요한경우>
     // @GetMapping("/schedules")
     //public List<ResponseSchedule> scheduleList(HttpSession session) {

        mockMvc.perform(get("/schedules") //호출 url    perform 다음에 오는 get은 맵핑이름 현재 겟맵핑 메서드 테스트 이기 때문.
                        .session(session))
//                        .session((session)).session(session)) // 세션이 여러개일경우 이런식으로 여러가지 세션을 넣을수있고.
//                        .param("","").param("","")) // 여러가지의 파라미터를 넣을수있다.
                .andExpect(status().isOk()) //결과 200(정상) 호출이 되어야함
                .andDo(print()); //출력
    }

    @Test
    @DisplayName("인서트 테스트")
    @Transactional  // 테스트에서 트랜젝셔널 어노테이션은 롤백을 의미 이 어노테이션이 없다면 테스트후 DB에 데이터가 삭제되 버리고 있다면 삭제헀다가 다시 원상복구한다.
    void scheduleInsertTest() throws Exception {

        //@PostMapping("/schedules") // 스케쥴을 입력하려면 email이 필요하다.
        //public String insertSchedule(RequestSchedule requestSchedule, HttpSession session) {


        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("email", String.valueOf(session.getAttribute("email")));
        param.add("id","10");
        param.add("title","안녕하세요");
        param.add("date","2020년 10월");

        mockMvc.perform(post("/schedules") //호출 url    perform 다음에 오는 post는 맵핑이름 현재 포스트맵핑 메서드 테스트 이기 때문.
                        .session(session).params(param))

                .andExpect(status().isOk()) //결과 200(정상) 호출이 되어야함
                .andExpect(content().string("success")) //응답이 "success"로 나와야함
                .andDo(print()); //출력
    }

}