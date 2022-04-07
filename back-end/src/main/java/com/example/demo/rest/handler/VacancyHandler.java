package com.example.demo.rest.handler;

import com.example.demo.entity.Vacancy;
import com.example.demo.rest.dto.VacancyDto;
import com.example.demo.rest.dto.common.PaginatedResultDto;
import com.example.demo.rest.entitymapper.VacancyMapper;
import com.example.demo.rest.entitymapper.common.PaginationMapper;
import com.example.demo.rest.exception.ResourceNotFoundException;
import com.example.demo.service.VacancyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@AllArgsConstructor
public class VacancyHandler {
    @Autowired
    private VacancyService vacancyService;
    private VacancyMapper vacancyMapper;
    private PaginationMapper paginationMapper;

    public ResponseEntity<?> getAll(Integer page, Integer size) {
        Page<Vacancy> vacancyPage = vacancyService.getAll(page, size);
        List<VacancyDto> vacancyDtoList = vacancyMapper.toDto(vacancyPage.getContent());
        PaginatedResultDto<VacancyDto> paginatedResult = new PaginatedResultDto<>();
        paginatedResult.setData(vacancyDtoList);
        paginatedResult.setPagination(paginationMapper.toPaginationDto(vacancyPage));
        return ResponseEntity.ok(paginatedResult);
    }

    public ResponseEntity<?> save(VacancyDto dto) {
        Vacancy vacancy = vacancyMapper.toEntity(dto);
        vacancyService.save(vacancy);
        VacancyDto vacancyDto = vacancyMapper.toDto(vacancy);
        return ResponseEntity.created(URI.create("/vacancy/" + vacancy.getId())).body(vacancyDto);
    }

    public ResponseEntity<?> update(Integer id, VacancyDto dto){
        Vacancy vacancy = vacancyService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Vacancy.class.getSimpleName(), id));
        vacancyMapper.updateEntityFromDto(dto, vacancy);
        vacancyService.update(vacancy);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getById(Integer id){
        Vacancy vacancy = vacancyService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Vacancy.class.getSimpleName(), id));
        VacancyDto vacancyDto = vacancyMapper.toDto(vacancy);
        return ResponseEntity.ok(vacancyDto);
    }

    public ResponseEntity<?> delete(Integer id){
        Vacancy vacancy = vacancyService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Vacancy.class.getSimpleName(), id));
        vacancyService.delete(vacancy);
        return ResponseEntity.noContent().build();
    }
}