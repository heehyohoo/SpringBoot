package com.example.jpapractice2.service;

import com.example.jpapractice2.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {

    //모든 로직은 서비스에서 이루어진다.

    ExamRepository examRepository;

    @Autowired
    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }




}
