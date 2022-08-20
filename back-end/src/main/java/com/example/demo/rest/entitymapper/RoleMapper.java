package com.example.demo.rest.entitymapper;

import com.example.demo.entity.Role;
import com.example.demo.rest.dto.RoleDto;
import com.example.demo.rest.entitymapper.common.JPAEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends JPAEntityMapper<Role, RoleDto> {
}
