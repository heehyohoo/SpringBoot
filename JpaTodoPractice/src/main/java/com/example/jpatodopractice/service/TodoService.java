package com.example.jpatodopractice.service;

import com.example.jpatodopractice.dto.ResponseTodo;

import java.util.List;

public interface TodoService {

    //할임목록 불러오기
    public List<ResponseTodo> todolist();
    // 할일 삭제
    String deleteTodos(String id);
    // 할일 등록
    String inserTodos(String todos);


}
