package com.example.demo.rest.entitymapper;

import com.example.demo.entity.Employee;
import com.example.demo.rest.dto.EmployeeDto;
import com.example.demo.rest.entitymapper.common.JPAEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends JPAEntityMapper<Employee, EmployeeDto> {}
