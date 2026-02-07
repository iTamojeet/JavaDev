package com.example.service;

import com.example.model.Answer;
import com.example.model.GetCountryRequest;
import com.example.model.Question;
import com.example.model.Topic;

public interface OpenAIService {

    String getAnswer(String question);

    Answer getAnswer(Question question);

    Answer getCountry(GetCountryRequest getCountryRequest);

    Answer getTopic(Topic topic);
}
