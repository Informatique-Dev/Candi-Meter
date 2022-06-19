package com.example.demo.rest.handler;

import com.example.demo.entity.Accept;
import com.example.demo.entity.Company;
import com.example.demo.rest.dto.AcceptDto;
import com.example.demo.rest.dto.CompanyDto;
import com.example.demo.rest.dto.common.PaginatedResultDto;
import com.example.demo.rest.entitymapper.AcceptMapper;
import com.example.demo.rest.entitymapper.common.PaginationMapper;
import com.example.demo.rest.exception.ResourceNotFoundException;
import com.example.demo.service.AcceptService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@AllArgsConstructor
public class AcceptHandler {
    @Autowired
    private AcceptService acceptService;
    private AcceptMapper acceptMapper;
    private PaginationMapper paginationMapper;

    public ResponseEntity<?> getAll(Integer page, Integer size) {
        Page<Accept> acceptPage = acceptService.getAll(page, size);
        List<AcceptDto> acceptDtoList = acceptMapper.toDto(acceptPage.getContent());
        PaginatedResultDto<AcceptDto> paginatedResult = new PaginatedResultDto<>();
        paginatedResult.setData(acceptDtoList);
        paginatedResult.setPagination(paginationMapper.toPaginationDto(acceptPage));
        return ResponseEntity.ok(paginatedResult);
    }

    public ResponseEntity<?> save(AcceptDto dto) {
        Accept accept = acceptMapper.toEntity(dto);
        acceptService.save(accept);
        AcceptDto acceptDto = acceptMapper.toDto(accept);
        return ResponseEntity.created(URI.create("/accept/" + accept.getId())).body(acceptDto);
    }

    public ResponseEntity<?> update(Integer id, AcceptDto dto){
        Accept accept = acceptService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Accept.class.getSimpleName(), id));
        acceptMapper.updateEntityFromDto(dto, accept);
        acceptService.update(accept);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getById(Integer id){
        Accept accept = acceptService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Accept.class.getSimpleName(), id));
        AcceptDto acceptDto = acceptMapper.toDto(accept);
        return ResponseEntity.ok(acceptDto);
    }

    public ResponseEntity<?> delete(Integer id){
        Accept accept = acceptService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Accept.class.getSimpleName(), id));
        acceptService.delete(accept);
        return ResponseEntity.noContent().build();
    }
}

