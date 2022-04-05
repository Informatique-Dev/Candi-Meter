package com.example.demo.rest.mapper;

import com.example.demo.rest.dto.PositionDto;
import com.example.demo.model.Position;
import com.example.demo.rest.mapper.common.JPAEntityMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PositionMapper extends JPAEntityMapper<Position,PositionDto> {}
