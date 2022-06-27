package com.example.demo.rest.entitymapper;

import com.example.demo.entity.Interview;
import com.example.demo.rest.dto.InterviewDto;
import com.example.demo.rest.entitymapper.common.JPAEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InterviewMapper extends JPAEntityMapper<Interview, InterviewDto> {}