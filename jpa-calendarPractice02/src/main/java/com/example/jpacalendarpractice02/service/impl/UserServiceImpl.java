package com.example.jpacalendarpractice02.service.impl;

import com.example.jpacalendarpractice02.dto.UserRequest;
import com.example.jpacalendarpractice02.entity.User;
import com.example.jpacalendarpractice02.repository.UserRepository;
import com.example.jpacalendarpractice02.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public String insertUser(UserRequest userRequest) {
        try {
            userRepository.save(userRequest.toEntity());
        } catch (Exception e) {
            return "failed";
        }
        return "success";
    }

    @Override
    public String selectUser(UserRequest userRequest) {

        User user = userRepository.findByEmailAndPassword(userRequest.getEmail(),userRequest.getPassword())
                .orElse(null);

        if(user != null) {
            return "success";
        }else{
            return "failed";
        }
    }
}
