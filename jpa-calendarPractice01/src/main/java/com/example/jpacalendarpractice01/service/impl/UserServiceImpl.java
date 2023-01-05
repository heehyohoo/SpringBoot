package com.example.jpacalendarpractice01.service.impl;

import com.example.jpacalendarpractice01.dto.RequestUser;
import com.example.jpacalendarpractice01.entity.User;
import com.example.jpacalendarpractice01.repository.UserRepository;
import com.example.jpacalendarpractice01.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public String insertUser(RequestUser requestUser) {
        try {
            userRepository.save(requestUser.toEntity());
        }catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    @Override
    public String selectUser(RequestUser requestUser) {

        User user = userRepository.findByEmailAndPassword(requestUser.getEmail(),requestUser.getPassword())
                .orElse(null);

        if(user != null) {
            return "success";
        }else{
            return "failed";
        }
    }
}
