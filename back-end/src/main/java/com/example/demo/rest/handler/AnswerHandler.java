package com.example.demo.rest.handler;

import com.example.demo.entity.Answer;
import com.example.demo.rest.dto.AnswerDto;
import com.example.demo.rest.dto.common.PaginatedResultDto;
import com.example.demo.rest.entitymapper.AnswerMapper;
import com.example.demo.rest.entitymapper.common.PaginationMapper;
import com.example.demo.rest.exception.ResourceNotFoundException;
import com.example.demo.service.AnswerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@AllArgsConstructor
public class AnswerHandler {
    @Autowired
    private AnswerService answerService;
    private AnswerMapper answerMapper;
    private PaginationMapper paginationMapper;

    public ResponseEntity<?> getAll(Integer page, Integer size) {
        Page<Answer> answerPage = answerService.getAll(page, size);
        List<AnswerDto> answerDtoList = answerMapper.toDto(answerPage.getContent());
        PaginatedResultDto<AnswerDto> paginatedResult = new PaginatedResultDto<>();
        paginatedResult.setData(answerDtoList);
        paginatedResult.setPagination(paginationMapper.toPaginationDto(answerPage));
        return ResponseEntity.ok(paginatedResult);
    }

    public ResponseEntity<?> save(AnswerDto dto) {
        Answer answer = answerMapper.toEntity(dto);
        answerService.save(answer);
        AnswerDto answerDto = answerMapper.toDto(answer);
        return ResponseEntity.created(URI.create("/answer/" + answer.getId())).body(answerDto);
    }

    public ResponseEntity<?> update(Integer id, AnswerDto dto){
        Answer answer = answerService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Answer.class.getSimpleName(), id));
        answerMapper.updateEntityFromDto(dto, answer);
        answerService.update(answer);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getById(Integer id){
        Answer answer = answerService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Answer.class.getSimpleName(), id));
        AnswerDto answerDto = answerMapper.toDto(answer);
        return ResponseEntity.ok(answerDto);
    }

    public ResponseEntity<?> delete(Integer id){
        Answer answer = answerService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Answer.class.getSimpleName(), id));
        answerService.delete(answer);
        return ResponseEntity.noContent().build();
    }
}

