package com.example.service;

import com.example.model.Answer;
import com.example.model.Question;

public interface OpenAiService {

    Answer getAnswer(Question question);

}
