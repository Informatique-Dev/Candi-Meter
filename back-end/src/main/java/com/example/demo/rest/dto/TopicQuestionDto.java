package com.example.demo.rest.dto;

import com.example.demo.rest.dto.common.RestDto;
import lombok.Data;

@Data
public class TopicQuestionDto extends RestDto {
    private String description;
    private String answer;
    private String hint;
}
