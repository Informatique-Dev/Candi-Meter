package com.example.demo.rest.dto;

import com.example.demo.rest.dto.common.RestDto;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class TopicsDto extends RestDto {
    private String name;
    private String description;
    private PositionDto position;
    private Set<TopicLevelDto> topicLevels = new LinkedHashSet<>();

}
