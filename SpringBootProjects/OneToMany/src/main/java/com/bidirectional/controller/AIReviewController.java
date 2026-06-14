package com.bidirectional.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ai")
@RequiredArgsConstructor
public class AIReviewController {
    private final ChatClient chatClient;

    @GetMapping("/review/{author}")
    public String getReview(@PathVariable("author") String author){
        return chatClient.prompt()
                .user("Give me reviews of books written by "+author)
                .call()
                .content();
    }
}
