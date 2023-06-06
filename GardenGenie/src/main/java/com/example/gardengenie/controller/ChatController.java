package com.example.gardengenie.controller;

import com.example.gardengenie.dto.ChatGptResponseDto;
import com.example.gardengenie.dto.QuestionRequestDto;
import com.example.gardengenie.repository.PlantRepository;
import com.example.gardengenie.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat-gpt")
public class ChatController {
    private final ChatService chatService;
    private final PlantRepository plantRepository;

    public ChatController(ChatService chatService, PlantRepository plantRepository) {
        this.chatService = chatService;
        this.plantRepository = plantRepository;
    }

    @PostMapping("/question")
    public ChatGptResponseDto sendQuestion() {
        String pltName = plantRepository.findMostRecentPltName();
        QuestionRequestDto requestDto = new QuestionRequestDto();
        requestDto.setBody(pltName);
        return chatService.askQuestion(requestDto);
    }

    @PostMapping("/ask/poem")
    public ChatGptResponseDto askPoem(@RequestBody QuestionRequestDto requestDto) {
        return chatService.askPoem(requestDto);

    }
}