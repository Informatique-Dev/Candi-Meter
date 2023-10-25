package com.example.demo.rest.dto;

import com.example.demo.rest.dto.common.RestDto;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class VacancyDto extends RestDto {


    private Integer count;

    private LocalDateTime expireDate;

    private PositionDto position;

    private String vacancies;

    private LocalDateTime postDate;

    private UserDto postBy;


}
