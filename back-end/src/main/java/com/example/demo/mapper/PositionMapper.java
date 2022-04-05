package com.example.demo.mapper;

import com.example.demo.dto.PositionDto;
import com.example.demo.model.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface PositionMapper {
    //Entity to Dto

    PositionDto mapToDto(Position position);
    List<PositionDto> mapToDto(List<Position> position);


    //Dto to Entity

    Position mapToEntity(PositionDto positionDto);


}
