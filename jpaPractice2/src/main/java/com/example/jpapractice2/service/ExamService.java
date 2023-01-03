package com.example.jpapractice2.service;

import com.example.jpapractice2.dto.ExamReqDTO;
import com.example.jpapractice2.dto.ExamResDTO;
import com.example.jpapractice2.entity.Exam;
import com.example.jpapractice2.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamService {

    //모든 로직은 서비스에서 이루어진다.

    ExamRepository examRepository;

    @Autowired
    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }


    //데이터 베이스에서 두 테이블을 merge 시키면 프라이머리키가 없으면 인서트를 하고, 같은 애가 있으면 업데이트를 하여 덮어 씀.
    public ExamResDTO merge(ExamReqDTO reqDTO) { // 반환타입은 안에서 나가는 DTO 타입이고 메서드 명은 merge 매개변수는 외부에서 들어오는 ReqDTO 객체
        Exam exam = reqDTO.toEntity();// ReqDTO 객체 매개변수로 빌더를 활용해 엔티티 객체로 변환한다 그러면 현재 상태는 엔티티 타입;
        examRepository.save(exam); // 이제 리포지토리에 저장하기위해  리포지토리에 save 메서드를 사용.(JPA API 에 있는 메서드)
                                   // JPA는 save 메서드는 객체의 PK값이 현재 테이블에 없다면 인서트를 실행하고
                                   // PK값이 현재 테이블에 있다면 업데이트를 실행한다. PK는 중복이 될수 없기 때문이다.
        return new ExamResDTO(exam.getName()); // 리턴값은 안에서 나가는 DTO 타입으로 객체를 생성하는데
                                               // 현재 ResDTO의 경우 필드의 멤버가 name만 있다 name만 넣어서 객체를 만들어 내보내겟다.
                                              // 필요시 필드를 늘리면 된다.
    }

    public List<ExamResDTO> selectAll() {
        List<Exam> list = examRepository.findAll();// 엔티티의 리스트 값이 나옴.
                                                    // 이것을 이제 Res타입 DTO 객체로 변환해야 한다.
        List<ExamResDTO> result = list.stream()     //변환하고자 하는 배열에 스트림을 호출
                .map(Exam -> new ExamResDTO(Exam.getName())) // 변환하고자 하는 배열을 Exam 이라고 칭하고 이것을 ㅡ> 변환할건데 새로운 객체로 만들거다. ResDTO의 getName을 가지고
                .collect(Collectors.toList()); // 다시 배열로 변환한다.
                // 원래는 for반복문을 사용해도 되지만 가독성이 좋은 코드를 만들기 위해 스트림을 사용한다.
                // 사실 성능면에서도 for문이 더 좋다고함. 유지보수 입장에서 봤을때 stream api를 사용하는것을 권장.
        return result;
    }





}
