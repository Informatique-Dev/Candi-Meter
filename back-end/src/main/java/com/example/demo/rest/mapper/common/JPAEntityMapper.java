package com.example.demo.rest.mapper.common;




import org.mapstruct.MappingTarget;

import java.util.List;
public interface JPAEntityMapper<T , S > {

    T toEntity(S s);

    S toDto(T t);

    List<T> toEntity(List<S> dtoList);

    List<S> toDto(List<T> dtoList);

    T updateEntityFromDto(S s, @MappingTarget T t);
}