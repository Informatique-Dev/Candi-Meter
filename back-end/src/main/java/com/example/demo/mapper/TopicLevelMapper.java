package com.example.demo.mapper;

import com.example.demo.dto.TopicLevelDto;
import com.example.demo.model.TopicLevel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TopicLevelMapper {
    TopicLevelMapper INSTANCE= Mappers.getMapper(TopicLevelMapper.class);
    @Mapping(source = "position.id",target = "positionId")
    TopicLevelDto mapToDto(TopicLevel topicLevel);

    List<TopicLevelDto> mapToDto(List<TopicLevel> topicLevel);
    @Mapping(source = "positionId",target = "position.id")
    TopicLevel mapToEntity(TopicLevelDto topicLevelDto);
}
