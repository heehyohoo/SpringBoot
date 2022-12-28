package com.example.jpapractice.controller;


import com.example.jpapractice.dto.ExampleReqDTO;
import com.example.jpapractice.dto.ExampleResDTO;
import com.example.jpapractice.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/selectAll")
    public List<ExampleResDTO> selectAll() {
        return exampleService.selectAll();
    }

    @GetMapping("/selectOne")
    public ExampleResDTO selectOne() {
        return exampleService.selectOne(new ExampleReqDTO(1L,"fish",1500));
    }

    @GetMapping("/deleteOne")
    public void deleteOne() {
        exampleService.deleteOne(new ExampleReqDTO(1L,"fish",1500));
    }

    @GetMapping("/deleteAll")
    public void deleteAll() {
        exampleService.deleteAll();
    }



}
