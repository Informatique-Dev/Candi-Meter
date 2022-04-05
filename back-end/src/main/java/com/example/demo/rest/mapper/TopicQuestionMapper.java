package com.example.demo.rest.mapper;

import com.example.demo.model.TopicQuestion;
import com.example.demo.rest.dto.TopicQuestionDto;
import com.example.demo.rest.mapper.common.JPAEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TopicQuestionMapper extends JPAEntityMapper<TopicQuestion, TopicQuestionDto> {
}
