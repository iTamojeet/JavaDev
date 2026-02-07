package com.example.service.impl;

import com.example.service.OpenAIService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OpenAIServiceImplTest {

    @Autowired
    private OpenAIService openAIService;


    @Test
    void getAnswer() {
        String output = openAIService.getAnswer("What is AI!?");
        IO.println(output);
    }
}