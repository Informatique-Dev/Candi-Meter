package com.example.demo.rest.handler;

import com.example.demo.entity.Question;
import com.example.demo.rest.dto.QuestionDto;
import com.example.demo.rest.dto.common.PaginatedResultDto;
import com.example.demo.rest.entitymapper.QuestionMapper;
import com.example.demo.rest.entitymapper.common.PaginationMapper;
import com.example.demo.rest.exception.ResourceNotFoundException;
import com.example.demo.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@AllArgsConstructor
public class QuestionHandler {
    @Autowired
    private QuestionService questionService;
    private QuestionMapper questionMapper;
    private PaginationMapper paginationMapper;

    public ResponseEntity<?> getAll(Integer page, Integer size) {
        Page<Question> questionPage = questionService.getAll(page, size);
        List<QuestionDto> questionDtoList = questionMapper.toDto(questionPage.getContent());
        PaginatedResultDto<QuestionDto> paginatedResult = new PaginatedResultDto<>();
        paginatedResult.setData(questionDtoList);
        paginatedResult.setPagination(paginationMapper.toPaginationDto(questionPage));
        return ResponseEntity.ok(paginatedResult);
    }

    public ResponseEntity<?> save(QuestionDto dto) {
        Question question = questionMapper.toEntity(dto);
        questionService.save(question);
        QuestionDto questionDto = questionMapper.toDto(question);
        return ResponseEntity.created(URI.create("/question/" + question.getId())).body(questionDto);
    }

    public ResponseEntity<?> update(Integer id, QuestionDto dto){
        Question question = questionService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Question.class.getSimpleName(), id));
        questionMapper.updateEntityFromDto(dto, question);
        questionService.update(question);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getById(Integer id){
        Question question = questionService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Question.class.getSimpleName(), id));
        QuestionDto questionDto = questionMapper.toDto(question);
        return ResponseEntity.ok(questionDto);
    }

    public ResponseEntity<?> delete(Integer id){
        Question question = questionService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Question.class.getSimpleName(), id));
        questionService.delete(question);
        return ResponseEntity.noContent().build();
    }
}

