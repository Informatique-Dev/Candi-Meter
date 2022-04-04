package com.example.demo.rest.dto;

import com.example.demo.rest.dto.common.RestDto;
import lombok.Data;

@Data
public class CompanyDto extends RestDto {

    private String name;

    private String description;

}
