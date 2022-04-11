package com.example.demo.rest.entitymapper;

import com.example.demo.entity.TopicQuestion;
import com.example.demo.rest.dto.TopicQuestionDto;
import com.example.demo.rest.entitymapper.common.JPAEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TopicQuestionMapper extends JPAEntityMapper<TopicQuestion, TopicQuestionDto> {}
