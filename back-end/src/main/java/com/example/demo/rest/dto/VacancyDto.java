package com.example.demo.rest.dto;

import com.example.demo.rest.dto.common.RestDto;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class VacancyDto extends RestDto {


    private Integer vacancies;

    private String postBy;

    private LocalDateTime postDate;

    private LocalDateTime expireDate;

    // private PositionDto position;
}
