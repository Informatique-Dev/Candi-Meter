package com.example.demo.rest.entitymapper;


import com.example.demo.entity.User;
import com.example.demo.rest.dto.UserDto;
import com.example.demo.rest.entitymapper.common.JPAEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends JPAEntityMapper<User, UserDto> {

}
