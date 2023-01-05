package com.example.jpacalendarpractice01.repository;

import com.example.jpacalendarpractice01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
