package com.example.service;

import com.example.model.Answer;
import com.example.model.Question;

public interface OpenaAIService {
    // public String getAnswer(String question);
    public Answer getAnswer(Question question);
}
