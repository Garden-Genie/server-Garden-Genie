//
package com.example.gardengenie.service;

import com.example.gardengenie.config.ChatGptConfig;
import com.example.gardengenie.dto.ChatGptRequestDto;
import com.example.gardengenie.dto.ChatGptResponseDto;
import com.example.gardengenie.dto.QuestionRequestDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.gardengenie.config.ChatGptConfig.*;

@Service
public class ChatService {

    private static final Logger logger = Logger.getLogger("com.example.gardengenie.service.ChatService");

    private static RestTemplate restTemplate = new RestTemplate();

    public HttpEntity<ChatGptRequestDto> buildHttpEntity(ChatGptRequestDto requestDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(ChatGptConfig.MEDIA_TYPE));
        headers.add(ChatGptConfig.AUTHORIZATION, ChatGptConfig.BEARER + ChatGptConfig.API_KEY);
        return new HttpEntity<>(requestDto, headers);
    }

    public ChatGptResponseDto getResponse(HttpEntity<ChatGptRequestDto> chatGptRequestDtoHttpEntity) {
        ResponseEntity<ChatGptResponseDto> responseEntity = restTemplate.postForEntity(
                ChatGptConfig.URL,
                chatGptRequestDtoHttpEntity,
                ChatGptResponseDto.class);

        return responseEntity.getBody();
    }

    public ChatGptResponseDto askGPTQuestion(QuestionRequestDto requestDto) {
        // 반복되는 말을 질문 앞에 추가
        String question = NAME_1TEXT + " <" + requestDto.getQuestion() + "> " + NAME_2TEXT;

        // 질문 로깅
        logger.log(Level.INFO, "====Question: {0}", question);


        return this.getResponse(
                this.buildHttpEntity(
                        new ChatGptRequestDto(
                                ChatGptConfig.MODEL,
                                requestDto.getQuestion(),
                                ChatGptConfig.MAX_TOKEN,
                                ChatGptConfig.TEMPERATURE,
                                ChatGptConfig.TOP_P
                        )
                )
        );
    }

    public ChatGptResponseDto askQuestion(QuestionRequestDto requestDto) {
        // 반복되는 말을 질문 앞에 추가
        String question = NAME_1TEXT + " <" + requestDto.getQuestion() + "> " + NAME_2TEXT;

        // 질문 로깅
        logger.log(Level.INFO, "====Question: {0}", question);


        return this.getResponse(
                this.buildHttpEntity(
                        new ChatGptRequestDto(
                                ChatGptConfig.MODEL,
                                requestDto.getQuestion(),
                                ChatGptConfig.MAX_TOKEN,
                                ChatGptConfig.TEMPERATURE,
                                ChatGptConfig.TOP_P
                        )
                )
        );
    }

    public ChatGptResponseDto askPoem(QuestionRequestDto requestDto) {
        // 반복되는 말을 질문 앞에 추가
        String question = POEM_1TEXT + " <" + requestDto.getQuestion() + "> " + POEM_2TEXT;

        // 질문 로깅
        logger.log(Level.INFO, "====Question: {0}", question);


        return this.getResponse(
                this.buildHttpEntity(
                        new ChatGptRequestDto(
                                ChatGptConfig.MODEL,
                                requestDto.getQuestion(),
                                ChatGptConfig.MAX_TOKEN,
                                ChatGptConfig.TEMPERATURE,
                                ChatGptConfig.TOP_P
                        )
                )
        );
    }
}
