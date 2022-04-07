package com.example.demo.rest.handler;

import com.example.demo.entity.Candidate;
import com.example.demo.rest.dto.CandidateDto;
import com.example.demo.rest.dto.common.PaginatedResultDto;
import com.example.demo.rest.entitymapper.CandidateMapper;
import com.example.demo.rest.entitymapper.common.PaginationMapper;
import com.example.demo.rest.exception.ResourceNotFoundException;
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
public class CandidateHandler {
    @Autowired
    private CandidateService candidateService;
    private CandidateMapper candidateMapper;
    private PaginationMapper paginationMapper;

    public ResponseEntity<?> getAll(Integer page, Integer size) {
        Page<Candidate> candidatePage = candidateService.getAll(page, size);
        List<CandidateDto> candidateDtoList = candidateMapper.toDto(candidatePage.getContent());
        PaginatedResultDto<CandidateDto> paginatedResult = new PaginatedResultDto<>();
        paginatedResult.setData(candidateDtoList);
        paginatedResult.setPagination(paginationMapper.toPaginationDto(candidatePage));
        return ResponseEntity.ok(paginatedResult);
    }

    public ResponseEntity<?> save(CandidateDto dto) {
        Candidate candidate = candidateMapper.toEntity(dto);
        candidateService.save(candidate);
        CandidateDto candidateDto = candidateMapper.toDto(candidate);
        return ResponseEntity.created(URI.create("/candidate/" + candidate.getId())).body(candidateDto);
    }

    public ResponseEntity<?> update(Integer id, CandidateDto dto){
        Candidate candidate = candidateService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Candidate.class.getSimpleName(), id));
        candidateMapper.updateEntityFromDto(dto, candidate);
        candidateService.update(candidate);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getById(Integer id){
        Candidate candidate = candidateService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Candidate.class.getSimpleName(), id));
        CandidateDto candidateDto = candidateMapper.toDto(candidate);
        return ResponseEntity.ok(candidateDto);
    }

    public ResponseEntity<?> delete(Integer id){
        Candidate candidate = candidateService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Candidate.class.getSimpleName(), id));
        candidateService.delete(candidate);
        return ResponseEntity.noContent().build();
    }

}
