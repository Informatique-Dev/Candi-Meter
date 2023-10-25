package com.example.demo.rest.handler;

import com.example.demo.entity.FollowUp;
import com.example.demo.entity.Interview;
import com.example.demo.rest.dto.FollowUpDto;
import com.example.demo.rest.dto.InterviewDto;
import com.example.demo.rest.dto.common.PaginatedResultDto;
import com.example.demo.rest.entitymapper.EmployeeMapper;
import com.example.demo.rest.entitymapper.FollowUpMapper;
import com.example.demo.rest.entitymapper.common.PaginationMapper;
import com.example.demo.rest.exception.ResourceNotFoundException;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.FollowUpService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@AllArgsConstructor
public class FollowUpHandler {

    @Autowired
    private FollowUpService followUpService;
    @Autowired
    private FollowUpMapper followUpMapper;
    private PaginationMapper paginationMapper;
    public ResponseEntity<?> save(FollowUpDto dto) {
        FollowUp followUp = followUpMapper.toEntity(dto);
        followUpService.save(followUp);
        FollowUpDto followUpDto = followUpMapper.toDto(followUp);
        return ResponseEntity.created(URI.create("/FollowUp/" + followUp.getId())).body(followUpDto);
    }
    public ResponseEntity<?> getById(Integer id){
        FollowUp followUp = followUpService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(FollowUp.class.getSimpleName(), id));
        FollowUpDto followUpDto = followUpMapper.toDto(followUp);
        return ResponseEntity.ok(followUpDto);
    }

    public ResponseEntity<?> delete(Integer id){
        FollowUp followUp = followUpService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(FollowUp.class.getSimpleName(), id));
        followUpService.delete(followUp);
        return ResponseEntity.noContent().build();
    }


    public ResponseEntity<?> getAllByInterview(Integer interviewId, Integer page, Integer size) {
        Page<FollowUp> followUpPage = followUpService.getAllByInterview(interviewId, page, size);
        List<FollowUpDto> followUpDtoList = followUpMapper.toDto(followUpPage.getContent());
        PaginatedResultDto<FollowUpDto> paginatedResultDto = new PaginatedResultDto<>();
        paginatedResultDto.setData(followUpDtoList);
        paginatedResultDto.setPagination(paginationMapper.toPaginationDto(followUpPage));
        return ResponseEntity.ok(paginatedResultDto);
    }

}

