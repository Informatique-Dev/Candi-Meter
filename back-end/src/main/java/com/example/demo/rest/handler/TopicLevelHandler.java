package com.example.demo.rest.handler;


import com.example.demo.entity.TopicLevel;

import com.example.demo.rest.dto.TopicLevelDto;
import com.example.demo.rest.dto.common.PaginatedResultDto;

import com.example.demo.rest.entitymapper.TopicLevelMapper;
import com.example.demo.rest.entitymapper.common.PaginationMapper;
import com.example.demo.rest.exception.ResourceNotFoundException;

import com.example.demo.service.TopicLevelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@AllArgsConstructor
public class TopicLevelHandler {
    @Autowired
    private TopicLevelService topicLevelService;
    private TopicLevelMapper topicLevelMapper;
    private PaginationMapper paginationMapper;

    public ResponseEntity<?> getAll(Integer page, Integer size) {
        Page<TopicLevel> topicLevelPage = topicLevelService.getAll(page, size);
        List<TopicLevelDto> topicLevelDtoList = topicLevelMapper.toDto(topicLevelPage.getContent());
        PaginatedResultDto<TopicLevelDto> paginatedResult = new PaginatedResultDto<>();
        paginatedResult.setData(topicLevelDtoList);
        paginatedResult.setPagination(paginationMapper.toPaginationDto(topicLevelPage));
        return ResponseEntity.ok(paginatedResult);
    }

    public ResponseEntity<?> save(TopicLevelDto dto) {
        TopicLevel topicLevel = topicLevelMapper.toEntity(dto);
        topicLevelService.save(topicLevel);
        TopicLevelDto topicLevelDto = topicLevelMapper.toDto(topicLevel);
        return ResponseEntity.created(URI.create("/topiclevel/" + topicLevel.getId())).body(topicLevelDto);
    }

    public ResponseEntity<?> update(Integer id, TopicLevelDto dto){
        TopicLevel topicLevel = topicLevelService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(TopicLevel.class.getSimpleName(), id));
        topicLevelMapper.updateEntityFromDto(dto, topicLevel);
        topicLevelService.update(topicLevel);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getById(Integer id){
        TopicLevel topicLevel = topicLevelService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(TopicLevel.class.getSimpleName(), id));
        TopicLevelDto topicLevelDto = topicLevelMapper.toDto(topicLevel);
        return ResponseEntity.ok(topicLevelDto);
    }

    public ResponseEntity<?> delete(Integer id){
        TopicLevel topicLevel = topicLevelService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(TopicLevel.class.getSimpleName(), id));
        topicLevelService.delete(topicLevel);
        return ResponseEntity.noContent().build();
    }
}
