package com.example.demo.rest.handler;



import com.example.demo.entity.Topics;

import com.example.demo.rest.dto.TopicsDto;
import com.example.demo.rest.dto.common.PaginatedResultDto;

import com.example.demo.rest.entitymapper.TopicsMapper;
import com.example.demo.rest.entitymapper.common.PaginationMapper;
import com.example.demo.rest.exception.ResourceNotFoundException;

import com.example.demo.service.TopicsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@AllArgsConstructor
public class TopicsHandler {
    @Autowired
    private TopicsService topicsService;
    private TopicsMapper topicsMapper;
    private PaginationMapper paginationMapper;

    public ResponseEntity<?> getAll(Integer page, Integer size) {
        Page<Topics> topicsPage = topicsService.getAll(page, size);
        List<TopicsDto> topicsDtoList = topicsMapper.toDto(topicsPage.getContent());
        PaginatedResultDto<TopicsDto> paginatedResult = new PaginatedResultDto<>();
        paginatedResult.setData(topicsDtoList);
        paginatedResult.setPagination(paginationMapper.toPaginationDto(topicsPage));
        return ResponseEntity.ok(paginatedResult);
    }

    public ResponseEntity<?> save(TopicsDto dto) {
        Topics topics = topicsMapper.toEntity(dto);
        topicsService.save(topics);
        TopicsDto topicsDto = topicsMapper.toDto(topics);
        return ResponseEntity.created(URI.create("/topics/" + topics.getId())).body(topicsDto);
    }

    public ResponseEntity<?> update(Integer id, TopicsDto dto){
        Topics topics = topicsService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Topics.class.getSimpleName(), id));
        topicsMapper.updateEntityFromDto(dto, topics);
        topicsService.update(topics);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getById(Integer id){
        Topics topics = topicsService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Topics.class.getSimpleName(), id));
        TopicsDto topicsDto = topicsMapper.toDto(topics);
        return ResponseEntity.ok(topicsDto);
    }

    public ResponseEntity<?> delete(Integer id){
        Topics topics = topicsService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Topics.class.getSimpleName(), id));
        topicsService.delete(topics);
        return ResponseEntity.noContent().build();
    }
}
