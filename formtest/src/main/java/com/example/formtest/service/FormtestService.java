package com.example.formtest.service;

import com.example.formtest.mapper.FormtestMapper;
import com.example.formtest.repository.FormtestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Service
public class FormtestService {

    @Autowired
    FormtestRepository fr;

    public int insertMember(@RequestParam HashMap<String, String> params) {
        return fr.insertMember(params);
    }




}
