package com.example.jpapractice2.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor // 전체파라미터 생성자 <롬복>
@NoArgsConstructor // 기본생성자 <롬복>
@Getter // 게터생성<롬복>
@Setter // 세터생성<롬복>
@Builder //
@Entity
@Table(name = "example") // 엔티티와 연결시킬 테이블을 지정하는데 테이블명과 엔티티명이 같으면 작성하지 않아도 된다.(그런일은 극히 드뭄)
public class Exam {

    @Id              // JPA는 꼭 프라이머리 키가 필요하다 프라이머리키 에 @Id 어노테이션을 붙여주자
    @Column(name = "id") // 데이터베이스에 컬럼값과 이름이 다를경우 지정해줄수 있다. 컬럼명과 변수명이 같우 생략 가능
    private Long id; // 보통은 ID는 LONG 자료형 사용한다.

    @Column(name = "name") // 엔티티클래스의 name을 example 테이블의 컬럼명 name과 맵핑하겠다.
    private String name;

    @Column(name = "price")
    private int price;

}

