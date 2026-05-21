package com.example.service.impl;

import com.example.model.Answer;
import com.example.model.Question;
import com.example.service.OpenAiService;
import lombok.AllArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OpenAiServiceImpl implements OpenAiService {

    private final ChatModel chatModel;

    @Override
    public Answer getAnswer(Question question) {
        PromptTemplate pt = new PromptTemplate(question.question());
        Prompt prompt = pt.create();
        ChatResponse response = chatModel.call(prompt);
        return new Answer(response.getResult().getOutput().getText());
    }
}
