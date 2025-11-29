package com.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OpenAITest {
    @Autowired
    OpenaAIService openaAIService;

//    @Test
//    public void test() {
//        String response = openaAIService.getAnswer("Tell me a bad joke!!!");
//        IO.println("The answer is:- " + response);
//    }
}
