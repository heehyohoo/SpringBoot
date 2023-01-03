package com.example.jpapractice2.controller;


import com.example.jpapractice2.dto.ExamReqDTO;
import com.example.jpapractice2.dto.ExamResDTO;
import com.example.jpapractice2.entity.Exam;
import com.example.jpapractice2.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExamContorller {

    ExamService examService;


    @Autowired
    public ExamContorller(ExamService examService) {
        this.examService = examService;
    }


    @GetMapping("/insert")
    public ExamResDTO mergeExam() {
        ExamReqDTO dto = new ExamReqDTO(1L, "fish", 1500); //임의의 들어오는 객체를 만들어줌 (프런트가 있다면 프런트에서 데이터를 받아 객체를 만듬)
        return examService.merge(dto); // 서비스에  merge 메서드안에 매개변수로 넣음.

        //실행을 해보니 데이터베이스에 값이 들어갔고, 해당페이지에는 {"name":"fish"} 제이슨형식의 필드에서 반환이 바로 된것을 알수있다.
        //여긴 레스트 컨트롤러니까.
        // 한번실행될때마다 콘솔창에 Hibernate 가 두번 출력되는데.
        // 첫번째거는 외부에서 들어온 객체의 PK값이 데이터베이스에 있는지 체크를 한다.
        // 없다면 값이 들어가고 있다면 그 PK에 해당하는 데이터베이스 테이블의 값을 업데이트 시킨다.
    }

    @GetMapping("/selectAll")
    public List<ExamResDTO> selectAll() {
        return examService.selectAll();

        //실행을 해보니 데이터베이스에 있는 값에 이름만 출력이 된것을 알수 있다. resDTO가 이름만 있기 때문이다.
    }
}
