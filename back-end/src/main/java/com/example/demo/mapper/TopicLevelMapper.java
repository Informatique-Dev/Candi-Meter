package com.example.demo.mapper;

import com.example.demo.dto.TopicLevelDto;
import com.example.demo.model.Position;
import com.example.demo.model.TopicLevel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Optional;

@Mapper(uses = {PositionMapper.class})
public interface TopicLevelMapper {
    //Entity to Dto
    @Mapping(source = "id",target = "topicLevelId")
    @Mapping(source = "describtion",target = "topicLevelDescribtion")
    @Mapping(source = "position.id",target = "positionId")
    TopicLevelDto mapToDto(Optional<TopicLevel> topicLevel);
    List<TopicLevelDto> mapToDto(List<TopicLevel> topicLevel);

    //Dto to Entity
    @Mapping(source = "topicLevelId",target = "id")
    @Mapping(source = "topicLevelDescribtion",target = "describtion")
    @Mapping(source = "positionId",target = "position.id")
    TopicLevel mapToEntity(TopicLevelDto topicLevelDto);

    //map update
    @Mapping(source = "topicLevelId",target = "id")
    @Mapping(source = "topicLevelDescribtion",target = "describtion")
    @Mapping(source = "positionId",target = "position.id")
    TopicLevel mapToUpdate(TopicLevelDto topicLevelDto, @MappingTarget Optional<TopicLevel> topicLevel);

}
