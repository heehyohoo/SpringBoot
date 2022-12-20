package com.example.ajextest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @GetMapping("/test")
    public String test(String name) {
        System.out.println(name);
        return "OK";
    }

}
