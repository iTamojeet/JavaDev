package com.example.service.impl;

import com.example.model.Answer;
import com.example.model.GetCountryRequest;
import com.example.model.Question;
import com.example.model.Topic;
import com.example.service.OpenAIService;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Map;

@Service
public class OpenAIServiceImpl implements OpenAIService {

    @Value("classpath:templates/myprompt.st")
    private Resource getCountry;
    @Value("classpath:templates/myprompt.st")
    private Resource getTopicData;

    public OpenAIServiceImpl(ChatModel chatModel) {
        this.chatModel = chatModel;
    }
    private final ChatModel chatModel;


    @Override
    public String getAnswer(String question) {
        PromptTemplate promptTemplate = new PromptTemplate(question);
        Prompt prompt = promptTemplate.create();
        ChatResponse chatResponse = chatModel.call(prompt);
        return chatResponse.getResult().getOutput().getText();
    }

    @Override
    public Answer getAnswer(Question question) {
        PromptTemplate promptTemplate = new PromptTemplate(question.question());
        Prompt prompt = promptTemplate.create();
        ChatResponse chatResponse = chatModel.call(prompt);
        return new Answer(chatResponse.getResult().getOutput().getText());
    }

    @Override
    public Answer getCountry(GetCountryRequest getCountryRequest) {
        PromptTemplate promptTemplate = new PromptTemplate(getCountry);
        Prompt prompt = promptTemplate.create(Map.of("nameOfCountry", getCountryRequest.nameOfCountry()));
        ChatResponse chatResponse = chatModel.call(prompt);
        return new Answer(chatResponse.getResult().getOutput().getText());
    }

    @Override
    public Answer getTopic(Topic topic) {
        PromptTemplate promptTemplate = new PromptTemplate(getTopicData);
        Prompt prompt = promptTemplate.create(Map.of("topic",topic.topic(),"exp",topic.exp()));
        ChatResponse chatResponse = chatModel.call(prompt);
        return new Answer(chatResponse.getResult().getOutput().getText());
    }
}
