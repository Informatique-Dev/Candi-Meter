package com.example.demo.rest.entitymapper;

import com.example.demo.entity.TopicLevel;
import com.example.demo.rest.dto.TopicLevelDto;

import com.example.demo.rest.entitymapper.common.JPAEntityMapper;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TopicLevelMapper extends JPAEntityMapper<TopicLevel, TopicLevelDto> {}
