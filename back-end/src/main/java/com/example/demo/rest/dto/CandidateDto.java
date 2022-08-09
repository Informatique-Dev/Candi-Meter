package com.example.demo.rest.dto;

import com.example.demo.rest.dto.common.RestDto;
import com.example.demo.rest.validation.InsertValidation;
import com.example.demo.rest.validation.UpdateValidation;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class CandidateDto extends RestDto {


    private String name;

    @Size(max = 11 , min = 11 ,message = " Should have length 11 numbers ",
            groups = {InsertValidation.class, UpdateValidation.class})
    private String phone;

    @Email(message = "Should be in Email format", regexp = "^(.+)@(.+)$"
            , groups = {InsertValidation.class, UpdateValidation.class})
    private String email;

    private Integer documentId;

    private PositionDto position;
}
