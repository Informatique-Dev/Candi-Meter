package com.example.demo.rest.entitymapper;


import com.example.demo.entity.Topics;

import com.example.demo.rest.dto.TopicsDto;
import com.example.demo.rest.entitymapper.common.JPAEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TopicsMapper extends JPAEntityMapper<Topics, TopicsDto> {}
