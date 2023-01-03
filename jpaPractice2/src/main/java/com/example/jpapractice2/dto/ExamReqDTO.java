package com.example.jpapractice2.dto;


import com.example.jpapractice2.entity.Exam;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ExamReqDTO {

    //Req DTO 는 리퀘스트 , 즉 밖에서 들어올때 사용될 DTO

    private Long id;
    private String name;
    private int price;

    public Exam toEntity() { //엔티티 객체를 생성하는 메소드
//        return new Exam(id,name,price); // 매개변수로 DTO 멤버를 사용하는것은 좋지 않다. 생산성이 떨어짐..
        return Exam.builder() // 엔티티클래스에 @Builder 어노테이션을 하였기 때문에 가능.
                              // 빌더 어노테이션은 생성자를 사용하지 않고 객체를 만드는것...?
                .id(id)   // 엔티티클래스의 id 값에 ExamReqDTO의 멤버 id를 연결 시키겟다.
                .name(name)
                .price(price)
                .build();

                            // builder를 사용하여 엔티티 객체를 생성한다.

    }


}
