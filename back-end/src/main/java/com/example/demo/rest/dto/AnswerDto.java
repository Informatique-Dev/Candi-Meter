package com.example.demo.rest.dto;

import com.example.demo.rest.dto.common.RestDto;
import lombok.Data;

@Data
public class AnswerDto extends RestDto {

    private String description;

    private ApplicationDto application;

    private CandidateDto candidate;

    private QuestionDto question;

}
