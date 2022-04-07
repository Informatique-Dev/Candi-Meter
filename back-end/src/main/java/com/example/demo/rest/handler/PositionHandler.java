package com.example.demo.rest.handler;


import com.example.demo.entity.Position;

import com.example.demo.rest.dto.PositionDto;
import com.example.demo.rest.dto.common.PaginatedResultDto;

import com.example.demo.rest.entitymapper.PositionMapper;
import com.example.demo.rest.entitymapper.common.PaginationMapper;
import com.example.demo.rest.exception.ResourceNotFoundException;

import com.example.demo.service.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@AllArgsConstructor
public class PositionHandler {
    @Autowired
    private PositionService positionService;
    private PositionMapper positionMapper;
    private PaginationMapper paginationMapper;

    public ResponseEntity<?> getAll(Integer page, Integer size) {
        Page<Position> positionPage = positionService.getAll(page, size);
        List<PositionDto> positionDtoList = positionMapper.toDto(positionPage.getContent());
        PaginatedResultDto<PositionDto> paginatedResult = new PaginatedResultDto<>();
        paginatedResult.setData(positionDtoList);
        paginatedResult.setPagination(paginationMapper.toPaginationDto(positionPage));
        return ResponseEntity.ok(paginatedResult);
    }

    public ResponseEntity<?> save(PositionDto dto) {
        Position position = positionMapper.toEntity(dto);
        positionService.save(position);
        PositionDto positionDto = positionMapper.toDto(position);
        return ResponseEntity.created(URI.create("/position/" + position.getId())).body(positionDto);
    }

    public ResponseEntity<?> update(Integer id, PositionDto dto){
        Position position = positionService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Position.class.getSimpleName(), id));
        positionMapper.updateEntityFromDto(dto, position);
        positionService.update(position);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getById(Integer id){
        Position position = positionService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Position.class.getSimpleName(), id));
        PositionDto positionDto = positionMapper.toDto(position);
        return ResponseEntity.ok(positionDto);
    }

    public ResponseEntity<?> delete(Integer id){
        Position position = positionService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Position.class.getSimpleName(), id));
        positionService.delete(position);
        return ResponseEntity.noContent().build();
    }
}
