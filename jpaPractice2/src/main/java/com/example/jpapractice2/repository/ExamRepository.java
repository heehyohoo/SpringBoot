package com.example.jpapractice2.repository;

import com.example.jpapractice2.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

//리포짓토리는 JpaRepository 를 상속받는 인터페이스로 생성 해야 한다.
public interface ExamRepository extends JpaRepository<Exam,Long> {   // <엔티티이름, 엔티티의 PK타입>


}
