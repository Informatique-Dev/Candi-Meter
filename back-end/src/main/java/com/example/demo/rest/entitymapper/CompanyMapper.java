package com.example.demo.rest.entitymapper;

import com.example.demo.entity.Company;
import com.example.demo.rest.dto.CompanyDto;
import com.example.demo.rest.entitymapper.common.JPAEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends JPAEntityMapper<Company, CompanyDto> {}
