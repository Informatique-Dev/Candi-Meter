package com.example.demo.mapper;

import com.example.demo.dto.TopicsDto;
import com.example.demo.model.Topics;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = TopicQuestionMapper.class)

public interface TopicsMapper {
    TopicsMapper INSTANCE= Mappers.getMapper(TopicsMapper.class);
    @Mapping(source = "topicLevel.id",target = "topicLevelId")
    @Mapping(source = "position.id",target = "positionId")
    @Mapping(source = "topicQuestions",target = "topicQuestions")
    TopicsDto mapToDto(Topics topics);
    List<TopicsDto> mapToDto(List<Topics> topics);

    @Mapping(source = "topicLevelId",target ="topicLevel.id" )
    @Mapping(source = "positionId",target ="position.id" )
    @Mapping(source = "topicQuestions",target ="topicQuestions" )
    Topics mapToEntity(TopicsDto topicsDto);


}
