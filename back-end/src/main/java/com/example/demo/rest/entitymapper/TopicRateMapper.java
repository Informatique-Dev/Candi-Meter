package com.example.demo.rest.entitymapper;

import com.example.demo.entity.TopicRate;
import com.example.demo.rest.dto.TopicRateDto;
import com.example.demo.rest.entitymapper.common.JPAEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TopicRateMapper extends JPAEntityMapper<TopicRate, TopicRateDto> {}
