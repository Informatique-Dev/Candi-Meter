package com.example.demo.rest.entitymapper;

import com.example.demo.entity.Vacancy;
import com.example.demo.rest.dto.VacancyDto;
import com.example.demo.rest.entitymapper.common.JPAEntityMapper;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface VacancyMapper extends JPAEntityMapper<Vacancy, VacancyDto> {}
