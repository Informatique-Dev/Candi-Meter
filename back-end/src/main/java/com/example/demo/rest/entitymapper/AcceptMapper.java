package com.example.demo.rest.entitymapper;

import com.example.demo.entity.Accept;
import com.example.demo.rest.dto.AcceptDto;
import com.example.demo.rest.entitymapper.common.JPAEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcceptMapper extends JPAEntityMapper<Accept, AcceptDto> {
}
