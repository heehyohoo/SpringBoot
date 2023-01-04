package com.example.jpapractice3.service;

import com.example.jpapractice3.dto.ResponseDTO;

import java.util.List;

public interface TodoService {

    //할일 가져오기.
    public List<ResponseDTO> todolist();

    // 할일등록
    public String insertTodo(String todos);

    //할일 삭제
    public String deleteTodo(String id);
}
