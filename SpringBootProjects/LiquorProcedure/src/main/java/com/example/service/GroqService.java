package com.example.service;

import com.example.entity.Product;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class GroqService {

    private final String GROQ_URL = "https://api.groq.com/openai/v1/chat/completions";
    private final String API_KEY = System.getenv("GROQ_API_KEY");

    public String getRecommendations(String query, List<Product> products) {

        RestTemplate restTemplate = new RestTemplate();

        String prompt = "You are a product recommendation AI.\n\n" +
                "USER QUERY:\n" + query + "\n\n" +
                "AVAILABLE PRODUCTS:\n" + products.toString();

        Map<String, Object> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", prompt);

        Map<String, Object> request = new HashMap<>();
        request.put("model", "llama-3.1-8b-instant");
        request.put("messages", List.of(message));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(API_KEY);

        HttpEntity<Map<String, Object>> entity =
                new HttpEntity<>(request, headers);

        Map response = restTemplate.postForObject(
                GROQ_URL,
                entity,
                Map.class);

        // extract response text
        List choices = (List) response.get("choices");
        Map choice = (Map) choices.get(0);
        Map msg = (Map) choice.get("message");

        return msg.get("content").toString();
    }
}