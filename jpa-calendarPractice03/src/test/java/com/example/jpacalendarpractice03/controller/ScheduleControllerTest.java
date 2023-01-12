package com.example.jpacalendarpractice03.controller;

import com.example.jpacalendarpractice03.dto.ResponseSchedule;
import com.example.jpacalendarpractice03.service.ScheduleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class ScheduleControllerTest {

    // <내부에서 테스트 하는 방법> mockito를 활용
    @Mock // 가짜 모조품 컨트롤러를 구동테스트 해보려면 서비스가 주입이 되어있어야 한다. 가짜 서비스를 만듬
    private ScheduleService scheduleService;
    @InjectMocks // 가짜 서비스를 컨트롤러에 주입
    private ScheduleController scheduleController;
    @Mock
    HttpSession httpSession;

    @Test
    void scheduleSelectTest() {
        // public List<ResponseSchedule> scheduleList(HttpSession session) 테스트하고자 하는 메서드****************
        // 이 메서드가 실행시 ResponseSchedule 타입의 List를 반환한다.
        // 그러면 이 메서드를 실행 결과를 보기위해서는 반환타입이 ResponseSchedule인 List가 필요하다.
        // 그래서 ResponseSchedule타입의 객체를 하나 만들어 리스트에 넣어서 가짜 List<ResponseSchedule> 를 만드는 과정
        ResponseSchedule responseSchedule = new ResponseSchedule("8","studyJPA","2023-01-18");
        List<ResponseSchedule> result = new ArrayList<>(); // 이 레코드를
        result.add(responseSchedule);
        // 요기 까지 하면 가짜 List<ResponseSchedule> relust 가 완성 되었다.

//      <  given().willReturn();  >
        //given()의 매개변수에 호출할 메서드를 입력 .willReturn() 의 매개변수의 결과값이 나오면 테스트 성공
        //여기서 결과값은 미리 만들어둔 가짜 List<ResponseSchedule> relust 이고
        // 실행하는 메서드는

        given(scheduleController.scheduleList(httpSession)).willReturn(result);
        // 가짜 서비스를 주입한 가짜 컨트롤러에서 해당 테스트하고자 하는 메서드 ****** 확인하여 불러오고
        // 해당메서드는 매개변수로 세션값이 필요하니 세션 또한 @Mock 어노테이션을 활용하여 가짜 세션도 만들어준다.
        // 그러면 결과는 해당메서드를 실행하면 결과로 미리 만들어둔 가짜 리절트값이 나오냐 확인하는것임.

        List<ResponseSchedule> testResult = scheduleController.scheduleList(httpSession);

        //Assertions.assertEquals("8",testResult.get(0).getId());
        // 매개변수 (기준값,비교값)  컴마 를 기준으로 값이 같은지 확인한다.
        // "8" 과 testResult.get(0).getId() 값이 같은지 확인하는것. 맞다면 테스트가 성공할것이다.

        Assertions.assertEquals("studyJPA",testResult.get(0).getTitle());
        //"studyJPA" 와 testResult.get(0).getTitle()의 값이 같은지 비교해서 맞다면 테스트가 성공을 한다.


        //<여기까지 내부테스트>
        // 내부적 테스트의 좋은점은 메서드가 완성 , 구현체가 없어도 이 메서드가 실행이 가능할지 안할지 확인을 할수있다.
        // 현재 테스트케이스의 자체가 단순하기때문에 간단하게 테스트를 할수있게 되었다.
        // 컨트롤러에 메서드를 직접 호출하여 내부적으로 테스트를 진행했다.

    }
}