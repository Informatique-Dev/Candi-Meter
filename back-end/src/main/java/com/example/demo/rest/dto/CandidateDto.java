package com.example.demo.rest.dto;

import com.example.demo.rest.dto.common.RestDto;
import lombok.Data;

@Data
public class CandidateDto extends RestDto {


    private String name;

    private String phone;

    private String email;

    // private DocumentDto document;
}
