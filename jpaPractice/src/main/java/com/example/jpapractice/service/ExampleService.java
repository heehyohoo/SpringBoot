package com.example.jpapractice.service;


import com.example.jpapractice.dto.ExampleReqDTO;
import com.example.jpapractice.dto.ExampleResDTO;
import com.example.jpapractice.entity.Example;
import com.example.jpapractice.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    ExampleRepository exampleRepository;

    @Autowired
    public ExampleService(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }
    public ExampleResDTO merge(ExampleReqDTO req) {
        Example example = req.toEntity();
        exampleRepository.save(example);

        return new ExampleResDTO(example.getName());
    }



}
