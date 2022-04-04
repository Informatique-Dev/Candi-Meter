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
    @Mapping(source = "id",target = "positionId")
    @Mapping(source = "name",target = "positionName")
    PositionDto mapToDto(Position position);
    List<PositionDto> mapToDto(List<Position> position);


    //Dto to Entity
    @Mapping(source = "positionId",target = "id")
    @Mapping(source = "positionName",target = "name")
    Position mapToEntity(PositionDto positionDto);

    //map update
    @Mapping(source = "positionId",target = "id")
    @Mapping(source = "positionName",target = "name")
    Position mapToUpdate(PositionDto positionDto, @MappingTarget Position position);
}
