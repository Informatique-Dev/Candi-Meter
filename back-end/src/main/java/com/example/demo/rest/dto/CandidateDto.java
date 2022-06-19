package com.example.demo.rest.dto;

import com.example.demo.rest.dto.common.RestDto;
import lombok.Data;

import javax.persistence.Column;

@Data
public class CandidateDto extends RestDto {


    private String name;

    private String phone;

    private String email;

    private Integer documentId;}
