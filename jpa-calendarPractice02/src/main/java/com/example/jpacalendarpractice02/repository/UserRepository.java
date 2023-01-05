package com.example.jpacalendarpractice02.repository;

import com.example.jpacalendarpractice02.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByEmailAndPassword(String email, String password);
}
