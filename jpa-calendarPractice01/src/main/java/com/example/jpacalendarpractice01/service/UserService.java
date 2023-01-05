package com.example.jpacalendarpractice01.service;

import com.example.jpacalendarpractice01.dto.RequestUser;

public interface UserService {

    String insertUser(RequestUser requestUser);

    String selectUser(RequestUser requestUser);

}
