package com.example.demo.rest.dto;


import com.example.demo.rest.dto.common.RestDto;
import lombok.Data;

@Data
public class ApplicationDto extends RestDto {

    private VacancyDto vacancy;

    private CandidateDto candidate;

    // private QuestionDto question;

    // private DocumentDto document;
}
