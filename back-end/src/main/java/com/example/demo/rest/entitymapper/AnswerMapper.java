package com.example.demo.rest.entitymapper;

import com.example.demo.entity.Answer;
import com.example.demo.rest.dto.AnswerDto;
import com.example.demo.rest.entitymapper.common.JPAEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper extends JPAEntityMapper<Answer, AnswerDto> {
}
