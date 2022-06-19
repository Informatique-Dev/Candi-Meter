package com.example.demo.rest.dto;


import com.example.demo.rest.dto.common.RestDto;
import lombok.Data;

import javax.persistence.Column;
@Data
public class PositionDto extends RestDto {

    private String name;
    private String describtion;


}
