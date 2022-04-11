package com.example.demo.rest.dto;

import com.example.demo.rest.dto.common.RestDto;
import lombok.Data;

@Data
public class EmployeeDto extends RestDto {

    private String name;

    private CompanyDto company;

    // private PositionDto position;

}
