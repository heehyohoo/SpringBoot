package com.example.todolist.mapper;


import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface TodoListMapper  {


    public int insertTodo(String todo);

    public ArrayList<String> selectAllTodo();

    public int deleteTodo(int id);

}
