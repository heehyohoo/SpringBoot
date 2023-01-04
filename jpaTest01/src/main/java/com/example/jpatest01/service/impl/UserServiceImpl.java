package com.example.jpatest01.service.impl;

import com.example.jpatest01.dto.UserRequest;
import com.example.jpatest01.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserService userService;
    @Override
    public String insertUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public String selectUser(UserRequest userRequest) {
        return null;
    }
}
