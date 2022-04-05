package com.example.demo.mapper;

import com.example.demo.dto.TopicQuestionDto;
import com.example.demo.model.TopicQuestion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TopicQuestionMapper {
    TopicQuestionMapper INSTANCE= Mappers.getMapper(TopicQuestionMapper.class);

    TopicQuestionDto mapToDto(TopicQuestion topicQuestion);
    List<TopicQuestionDto> mapToDto(List<TopicQuestion> topicQuestion);

    TopicQuestion mapToEntity(TopicQuestionDto topicQuestionDto);
}
