package com.example.jpacalendarpractice03.service;

import com.example.jpacalendarpractice03.dto.RequestUser;


public interface UserService {

    //사용자 등록 성공하면 success , 실패하면 failed 를 리턴이므로 반환타입은 String
    String insertUser(RequestUser requestUser);

    //사용자 조회 성공하면 success , 실패하면 failed 를 리턴이므로 반환타입은 String
    String selectUser(RequestUser requestUser);

}
