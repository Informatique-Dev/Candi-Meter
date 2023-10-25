package com.example.demo.rest.dto;


import com.example.demo.entity.Topics;
import com.example.demo.rest.dto.common.RestDto;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class TopicLevelDto extends RestDto {
    private String describtion;
    private PositionDto position;

}
