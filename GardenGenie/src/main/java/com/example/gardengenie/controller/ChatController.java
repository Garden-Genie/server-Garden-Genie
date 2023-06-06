package com.example.gardengenie.controller;

import com.example.gardengenie.dto.ChatGptResponseDto;
import com.example.gardengenie.dto.QuestionRequestDto;
import com.example.gardengenie.repository.PlantRepository;
import com.example.gardengenie.service.ChatService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chat-gpt")
public class ChatController {
    private final ChatService chatService;
    private final PlantRepository plantRepository;

    public ChatController(ChatService chatService, PlantRepository plantRepository) {
        this.chatService = chatService;
        this.plantRepository = plantRepository;
    }

    @PostMapping("/question/name")
    public ChatGptResponseDto sendQuestion() {
        String pltName = plantRepository.findMostRecentPltName();

        QuestionRequestDto requestDto = new QuestionRequestDto();
        requestDto.setBody("식물 <" + pltName + ">에 대해서 3줄 이내로 설명해줘." + "이때 식물 이름은 한국말로 말해줘.");

        // 로그 출력
        System.out.println("=============Request Body: " + requestDto.getBody());

        return chatService.askQuestion(requestDto);
    }

    private List<Map<String, String>> getMessages(QuestionRequestDto requestDto) {
        List<Map<String, String>> messages = new ArrayList<>();

        Map<String, String> userMessage = new HashMap<>();
        userMessage.put("role", "user");
        userMessage.put("content", requestDto.getBody());
        messages.add(userMessage);

        return messages;
    }

    @PostMapping("/question/music")
    public ChatGptResponseDto sendMusic() {
        String pltName = plantRepository.findMostRecentPltName();

        QuestionRequestDto requestDto = new QuestionRequestDto();
        requestDto.setBody("Your answer form should be like this: <title>-'artist'. Don't say any other words except for this."
                +"Give me a song related to <" + pltName + ">. The song should have more than 1,000 hits on Youtube. " +
                "If you don't find a song that meets the criteria, please suggest a song about plants that meets the above criteria.");

        // 로그 출력
        System.out.println("=============Request Body: " + requestDto.getBody());

        return chatService.askQuestion(requestDto);
    }

    @PostMapping("/question/poem")
    public ChatGptResponseDto sendPoem() {
        String pltName = plantRepository.findMostRecentPltName();

        QuestionRequestDto requestDto = new QuestionRequestDto();
        requestDto.setBody("식물 <" + pltName + ">과 관련된 시를 창작해줘.");

        // 로그 출력
        System.out.println("=============Request Body: " + requestDto.getBody());

        return chatService.askQuestion(requestDto);
    }

    @PostMapping("/question/advice")
    public ChatGptResponseDto sendAdvice() {
        String pltName = plantRepository.findMostRecentPltName();

        QuestionRequestDto requestDto = new QuestionRequestDto();
        requestDto.setBody("Your answer form should start with this: '몇가지 조언을 드리겠습니다.'"+
                "식물 <" + pltName + ">를 키울 때 주의 할 점이나 조언을 3줄 이내로 해줘."+
                "번호 없이 구어체로 말해줘."+ "이때 식물 이름은 한국말로 말해줘.");

        // 로그 출력
        System.out.println("=============Request Body: " + requestDto.getBody());

        return chatService.askQuestion(requestDto);
    }

}