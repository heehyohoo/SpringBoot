package com.example.jpapractice.controller;


import com.example.jpapractice.dto.ExampleReqDTO;
import com.example.jpapractice.dto.ExampleResDTO;
import com.example.jpapractice.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    ExampleService exampleService;


    @Autowired
    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping("/insert")
    public ExampleResDTO mergeExample() {
        ExampleReqDTO dto = new ExampleReqDTO(1L,"fish",1500);
        return exampleService.merge(dto);
    }
}
