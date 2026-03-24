package com.example.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OpenAIService {

    @Value("${spring.ai.openai.api-key}")
    private String API_KEY;

    public String askAI(String prompt) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.openai.com/v1/chat/completions";
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(API_KEY);
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> body = new HashMap<>();
        body.put("model", "gpt-4o-mini");
        List<Map<String, String>> messages = List.of(
                Map.of("role", "user", "content", prompt)
        );
        body.put("messages", messages);
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        ResponseEntity<Map> response =
                restTemplate.postForEntity(url, request, Map.class);
        return response.getBody().toString();
    }
}
