package com.example.demo.rest.handler;



import com.example.demo.entity.TopicQuestion;

import com.example.demo.rest.dto.TopicQuestionDto;
import com.example.demo.rest.dto.common.PaginatedResultDto;

import com.example.demo.rest.entitymapper.TopicQuestionMapper;
import com.example.demo.rest.entitymapper.common.PaginationMapper;
import com.example.demo.rest.exception.ResourceNotFoundException;

import com.example.demo.service.TopicQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@AllArgsConstructor
public class TopicQuestionHandler {
    @Autowired
    private TopicQuestionService topicQuestionService;
    private TopicQuestionMapper topicQuestionMapper;
    private PaginationMapper paginationMapper;

    public ResponseEntity<?> getAll(Integer page, Integer size) {
        Page<TopicQuestion> topicQuestionPage = topicQuestionService.getAll(page, size);
        List<TopicQuestionDto> topicQuestionDtoList = topicQuestionMapper.toDto(topicQuestionPage.getContent());
        PaginatedResultDto<TopicQuestionDto> paginatedResult = new PaginatedResultDto<>();
        paginatedResult.setData(topicQuestionDtoList);
        paginatedResult.setPagination(paginationMapper.toPaginationDto(topicQuestionPage));
        return ResponseEntity.ok(paginatedResult);
    }

    public ResponseEntity<?> save(TopicQuestionDto dto) {
        TopicQuestion topicQuestion = topicQuestionMapper.toEntity(dto);
        topicQuestionService.save(topicQuestion);
        TopicQuestionDto topicQuestionDto = topicQuestionMapper.toDto(topicQuestion);
        return ResponseEntity.created(URI.create("/topicquestion/" + topicQuestion.getId())).body(topicQuestionDto);
    }

    public ResponseEntity<?> update(Integer id, TopicQuestionDto dto){
        TopicQuestion topicQuestion = topicQuestionService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(TopicQuestion.class.getSimpleName(), id));
        topicQuestionMapper.updateEntityFromDto(dto, topicQuestion);
        topicQuestionService.update(topicQuestion);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getById(Integer id){
        TopicQuestion topicQuestion = topicQuestionService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(TopicQuestion.class.getSimpleName(), id));
        TopicQuestionDto topicQuestionDto = topicQuestionMapper.toDto(topicQuestion);
        return ResponseEntity.ok(topicQuestionDto);
    }

    public ResponseEntity<?> delete(Integer id){
        TopicQuestion topicQuestion = topicQuestionService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(TopicQuestion.class.getSimpleName(), id));
        topicQuestionService.delete(topicQuestion);
        return ResponseEntity.noContent().build();
    }
}
