package com.example.demo.rest.handler;

import com.example.demo.entity.Application;
import com.example.demo.entity.Candidate;
import com.example.demo.rest.dto.ApplicationDto;
import com.example.demo.rest.dto.CandidateDto;
import com.example.demo.rest.dto.common.PaginatedResultDto;
import com.example.demo.rest.entitymapper.ApplicationMapper;
import com.example.demo.rest.entitymapper.CandidateMapper;
import com.example.demo.rest.entitymapper.common.PaginationMapper;
import com.example.demo.rest.exception.ResourceNotFoundException;
import com.example.demo.service.ApplicationService;
import com.example.demo.service.CandidateService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@AllArgsConstructor
public class ApplicationHandler {
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private ApplicationMapper applicationMapper;
    @Autowired
    private PaginationMapper paginationMapper;

    public ResponseEntity<?> getAll(Integer page, Integer size) {
        Page<Application> applicationPage = applicationService.getAll(page, size);
        List<ApplicationDto> applicationDtoList = applicationMapper.toDto(applicationPage.getContent());
        PaginatedResultDto<ApplicationDto> paginatedResult = new PaginatedResultDto<>();
        paginatedResult.setData(applicationDtoList);
        paginatedResult.setPagination(paginationMapper.toPaginationDto(applicationPage));
        return ResponseEntity.ok(paginatedResult);
    }
    public ResponseEntity<?> getAllApplicationsByVacancyId(Integer page,Integer size,Integer id){
        List<Application> applicationPage = applicationService.getAllByVacancyId(page, size,id);
        List<ApplicationDto> applicationDtoList = applicationMapper.toDto(applicationPage);
        return ResponseEntity.ok(applicationDtoList);
    }
    public ResponseEntity<?> save(ApplicationDto dto) {
        Application application = applicationMapper.toEntity(dto);
        applicationService.save(application);
        ApplicationDto applicationDto = applicationMapper.toDto(application);
        return ResponseEntity.created(URI.create("/application/" + application.getId())).body(applicationDto);
    }

    public ResponseEntity<?> update(Integer id, ApplicationDto dto){
        Application application = applicationService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Candidate.class.getSimpleName(), id));
        applicationMapper.updateEntityFromDto(dto, application);
        applicationService.update(application);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getById(Integer id){
        Application application = applicationService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Candidate.class.getSimpleName(), id));
        ApplicationDto applicationDto = applicationMapper.toDto(application);
        return ResponseEntity.ok(applicationDto);
    }

    public ResponseEntity<?> delete(Integer id){
        Application application = applicationService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Candidate.class.getSimpleName(), id));
        applicationService.delete(application);
        return ResponseEntity.noContent().build();
    }

}
