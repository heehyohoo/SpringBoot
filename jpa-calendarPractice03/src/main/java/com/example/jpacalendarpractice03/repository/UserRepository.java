package com.example.jpacalendarpractice03.repository;

import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {


    //아이디와 패스워드를 넣어서 데이터베이스에 일치하는 값이 있는지 확인한다.
    // 옵셔널 객체로 감싸는 이유는 일치하는 값이 없으면 널이 될수 있기 때문.
    public Optional<User> findByIdAndPassword(String id, String password);
}
