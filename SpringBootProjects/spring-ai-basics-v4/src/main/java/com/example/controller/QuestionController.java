package com.example.controller;

import com.example.model.Answer;
import com.example.model.GetCountryRequest;
import com.example.model.Question;
import com.example.model.Topic;
import com.example.service.OpenAIService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api")
public class QuestionController {

    private final OpenAIService openAIService;

    @PostMapping("/ask")
    public ResponseEntity<Answer> askOpenAI(@RequestBody Question question){
        return new ResponseEntity<>(openAIService.getAnswer(question), HttpStatus.CREATED);
    }

    @PostMapping("/country")
    public Answer getCountry(@RequestBody GetCountryRequest getCountryRequest){
        return this.openAIService.getCountry(getCountryRequest);
    }

    @PostMapping("/topic")
    public Answer getCountry(@RequestBody Topic topic){
        return this.openAIService.getTopic(topic);
    }
}
