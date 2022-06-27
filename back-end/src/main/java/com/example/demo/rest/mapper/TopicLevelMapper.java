package com.example.demo.rest.mapper;

import com.example.demo.rest.dto.TopicLevelDto;
import com.example.demo.model.TopicLevel;
import com.example.demo.rest.mapper.common.JPAEntityMapper;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TopicLevelMapper extends JPAEntityMapper<TopicLevel,TopicLevelDto> {}
