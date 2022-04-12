package com.example.demo.rest.entitymapper;

import com.example.demo.entity.Question;
import com.example.demo.rest.dto.QuestionDto;
import com.example.demo.rest.entitymapper.common.JPAEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper extends JPAEntityMapper<Question, QuestionDto> {
}
