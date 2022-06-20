package com.example.demo.rest.dto;

import com.example.demo.rest.dto.common.RestDto;
import lombok.Data;

@Data
public class AcceptDto extends RestDto {

    private VacancyDto vacancy;

    // private InterviewDto interview;

}
