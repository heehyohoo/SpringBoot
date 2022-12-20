package com.example.formtest.repository;

import com.example.formtest.mapper.FormtestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Repository
public class FormtestRepository {

    @Autowired
    FormtestMapper fm;

    public int insertMember(@RequestParam HashMap<String, String> params) {
        return fm.insertMember(params);
    }





}
