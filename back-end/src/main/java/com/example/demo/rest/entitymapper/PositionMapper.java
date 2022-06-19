package com.example.demo.rest.entitymapper;

import com.example.demo.entity.Position;
import com.example.demo.rest.dto.PositionDto;


import com.example.demo.rest.entitymapper.common.JPAEntityMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PositionMapper extends JPAEntityMapper<Position,PositionDto> {}
