package com.example.demo.rest.entitymapper.common;

import com.example.demo.entity.common.JPAEntity;
import com.example.demo.rest.dto.common.RestDto;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface JPAEntityMapper<T extends JPAEntity, S extends RestDto> {

    T toEntity(S s);

    S toDto(T t);

    List<T> toEntity(List<S> dtoList);

    List<S> toDto(List<T> dtoList);

    T updateEntityFromDto(S s, @MappingTarget T t);
}