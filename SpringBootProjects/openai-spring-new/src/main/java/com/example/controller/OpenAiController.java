package com.example.controller;

import com.example.model.Answer;
import com.example.model.Question;
import com.example.service.OpenAiService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api")
public class OpenAiController {

    private final OpenAiService openAiService;
    @PostMapping
    public Answer askQ(@RequestBody Question question){
        return openAiService.getAnswer(question);
    }
}
