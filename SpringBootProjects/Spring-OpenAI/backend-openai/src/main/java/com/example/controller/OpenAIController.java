package com.example.controller;

import com.example.model.Answer;
import com.example.model.Question;
import com.example.service.OpenaAIService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin(value = "*")
public class OpenAIController {

    private final OpenaAIService openaAIService;

    public OpenAIController(OpenaAIService openaAIService) {
        this.openaAIService = openaAIService;
    }



    // http://localhost:8080/api/ask
    @PostMapping("ask")
    public Answer askOpenAI(@RequestBody Question question) {
        return openaAIService.getAnswer(question);
    }
}
