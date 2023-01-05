package com.example.jpacalendarpractice02.service;

import com.example.jpacalendarpractice02.dto.UserRequest;

public interface UserService {

    String insertUser(UserRequest userRequest);

    String selectUser(UserRequest userRequest);
}
