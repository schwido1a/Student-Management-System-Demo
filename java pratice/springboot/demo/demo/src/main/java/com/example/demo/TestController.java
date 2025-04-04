package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//this file is for testing
@RestController
public class TestController {

    @GetMapping("/testy")
    public String hello(){
        return "Bravo Haoxuan!";
    }
}
