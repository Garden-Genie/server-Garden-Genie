package com.example.gardengenie.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class QuestionRequestDto implements Serializable {
    private String question;

    public void setBody(String question) {
        this.question = question;
    }
}
