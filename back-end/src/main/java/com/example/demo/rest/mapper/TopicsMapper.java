package com.example.demo.rest.mapper;

import com.example.demo.model.Topics;
import com.example.demo.rest.dto.TopicsDto;
import com.example.demo.rest.mapper.common.JPAEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TopicsMapper extends JPAEntityMapper<Topics, TopicsDto> {
}
