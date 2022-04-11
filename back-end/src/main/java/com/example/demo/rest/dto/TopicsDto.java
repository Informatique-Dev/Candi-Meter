package com.example.demo.rest.dto;

import com.example.demo.rest.dto.common.RestDto;
import lombok.Data;

@Data
public class TopicsDto extends RestDto {
    private String name;
    private String description;
}
