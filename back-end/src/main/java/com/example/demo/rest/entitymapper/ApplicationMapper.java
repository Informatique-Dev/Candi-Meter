package com.example.demo.rest.entitymapper;

import com.example.demo.entity.Application;
import com.example.demo.rest.dto.ApplicationDto;
import com.example.demo.rest.entitymapper.common.JPAEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationMapper extends JPAEntityMapper<Application, ApplicationDto> {}
