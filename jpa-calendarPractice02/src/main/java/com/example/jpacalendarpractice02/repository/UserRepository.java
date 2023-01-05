package com.example.jpacalendarpractice02.repository;

import com.example.jpacalendarpractice02.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
