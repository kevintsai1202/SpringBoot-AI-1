package com.example.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ChatController {

    private final ChatClient chatClient;
    
    public ChatController(ChatClient.Builder builder) {
    	this.chatClient = builder.build();
    }

	@GetMapping("/ai")
	 String generation(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
		return chatClient.prompt()
						.user(message)
						.call()
						.content();
	}
}
