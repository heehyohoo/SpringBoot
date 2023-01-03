package com.example.jpatodo.repository;
import com.example.jpatodo.entity.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodolistRepository extends JpaRepository<Todolist,Long> {

}

