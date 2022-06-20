package com.example.demo.rest.handler;

import com.example.demo.entity.Interview;
import com.example.demo.rest.dto.InterviewDto;
import com.example.demo.rest.dto.common.PaginatedResultDto;
import com.example.demo.rest.entitymapper.InterviewMapper;
import com.example.demo.rest.entitymapper.common.PaginationMapper;
import com.example.demo.rest.exception.ResourceNotFoundException;
import com.example.demo.service.InterviewService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@AllArgsConstructor
public class InterviewHandler {
    @Autowired
    private InterviewService interviewService;
    private InterviewMapper interviewMapper;
    private PaginationMapper paginationMapper;

    public ResponseEntity<?> getAll(Integer page, Integer size) {
        Page<Interview> interviewPage = interviewService.getAll(page, size);
        List<InterviewDto> interviewDtoList = interviewMapper.toDto(interviewPage.getContent());
        PaginatedResultDto<InterviewDto> paginatedResult = new PaginatedResultDto<>();
        paginatedResult.setData(interviewDtoList);
        paginatedResult.setPagination(paginationMapper.toPaginationDto(interviewPage));
        return ResponseEntity.ok(paginatedResult);
    }

    public ResponseEntity<?> save(InterviewDto dto) {
        Interview interview = interviewMapper.toEntity(dto);
        interviewService.save(interview);
        InterviewDto interviewDto = interviewMapper.toDto(interview);
        return ResponseEntity.created(URI.create("/interview/" + interview.getId())).body(interviewDto);
    }

    public ResponseEntity<?> update(Integer id, InterviewDto dto){
        Interview interview = interviewService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Interview.class.getSimpleName(), id));
        interviewMapper.updateEntityFromDto(dto, interview);
        interviewService.update(interview);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getById(Integer id){
        Interview interview = interviewService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Interview.class.getSimpleName(), id));
        InterviewDto interviewDto = interviewMapper.toDto(interview);
        return ResponseEntity.ok(interviewDto);
    }

    public ResponseEntity<?> delete(Integer id){
        Interview interview = interviewService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Interview.class.getSimpleName(), id));
        interviewService.delete(interview);
        return ResponseEntity.noContent().build();
    }
}
