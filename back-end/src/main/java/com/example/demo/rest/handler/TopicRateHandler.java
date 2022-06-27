package com.example.demo.rest.handler;

import com.example.demo.entity.TopicRate;
import com.example.demo.rest.dto.TopicRateDto;
import com.example.demo.rest.dto.common.PaginatedResultDto;
import com.example.demo.rest.entitymapper.TopicRateMapper;
import com.example.demo.rest.entitymapper.common.PaginationMapper;
import com.example.demo.rest.exception.ResourceNotFoundException;
import com.example.demo.service.TopicRateService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

 @Component
@AllArgsConstructor
public class TopicRateHandler {
    @Autowired
    private TopicRateService topicRateService;
    private TopicRateMapper topicRateMapper;
    private PaginationMapper paginationMapper;

    public ResponseEntity<?> getAll(Integer page, Integer size) {
        Page<TopicRate> topicRatePage = topicRateService.getAll(page, size);
        List<TopicRateDto> topicRateDtoList = topicRateMapper.toDto(topicRatePage.getContent());
        PaginatedResultDto<TopicRateDto> paginatedResult = new PaginatedResultDto<>();
        paginatedResult.setData(topicRateDtoList);
        paginatedResult.setPagination(paginationMapper.toPaginationDto(topicRatePage));
        return ResponseEntity.ok(paginatedResult);
    }

    public ResponseEntity<?> save(TopicRateDto dto) {
        TopicRate topicRate = topicRateMapper.toEntity(dto);
        topicRateService.save(topicRate);
        TopicRateDto topicRateDto = topicRateMapper.toDto(topicRate);
        return ResponseEntity.created(URI.create("/topicrate/" + topicRate.getId())).body(topicRateDto);
    }

    public ResponseEntity<?> update(Integer id, TopicRateDto dto){
        TopicRate topicRate = topicRateService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(TopicRate.class.getSimpleName(), id));
        topicRateMapper.updateEntityFromDto(dto, topicRate);
        topicRateService.update(topicRate);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getById(Integer id){
        TopicRate topicRate = topicRateService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(TopicRate.class.getSimpleName(), id));
        TopicRateDto topicRateDto = topicRateMapper.toDto(topicRate);
        return ResponseEntity.ok(topicRateDto);
    }

    public ResponseEntity<?> delete(Integer id){
        TopicRate topicRate = topicRateService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(TopicRate.class.getSimpleName(), id));
        topicRateService.delete(topicRate);
        return ResponseEntity.noContent().build();
    }
}

