package com.example.jpacalendarpractice03.service.impl;


import com.example.jpacalendarpractice03.dto.RequestUser;
import com.example.jpacalendarpractice03.repository.UserRepository;
import com.example.jpacalendarpractice03.service.UserService;
import com.example.jpacalendarpractice03.entity.User;
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
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    @Override
    public String selectUser(RequestUser requestUser) {

        User user = userRepository.findByEmailAndPassword(requestUser.getEmail(), requestUser.getPassword()).orElse(null);

        if (user != null) {
            return "success";
        } else {
            return "failed";
        }

    }

}
