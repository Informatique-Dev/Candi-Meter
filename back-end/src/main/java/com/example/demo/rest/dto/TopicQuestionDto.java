package com.example.demo.rest.dto;

import lombok.Data;

@Data
public class TopicQuestionDto {
    private Long id;
    private String description;
    private String answer;
    private String hint;
}
