package com.example.jpapractice.service;


import com.example.jpapractice.dto.ExampleReqDTO;
import com.example.jpapractice.dto.ExampleResDTO;
import com.example.jpapractice.entity.Example;
import com.example.jpapractice.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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


    public List<ExampleResDTO> selectAll() {

        List<Example> result = exampleRepository.findAll();

        List<ExampleResDTO> resList = result.stream()
                .map(ex -> new ExampleResDTO((ex.getName())))
                .collect(Collectors.toList());

        return resList;
    }

    public ExampleResDTO selectOne(ExampleReqDTO exampleReqDTO) {
        Optional<Example> id = exampleRepository.findById(exampleReqDTO.getId());
        return new ExampleResDTO(id.orElse(null).getName());
    }



}
