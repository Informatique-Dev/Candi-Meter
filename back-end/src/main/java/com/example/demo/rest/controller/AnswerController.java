package com.example.demo.rest.controller;

import com.example.demo.rest.dto.AnswerDto;
import com.example.demo.rest.dto.CompanyDto;
import com.example.demo.rest.handler.AnswerHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
@AllArgsConstructor
@Tag(name = "answer", description = "REST API for answer")
public class AnswerController {
    private AnswerHandler answerHandler;

    @GetMapping
    @Operation(summary = "get All answer ")
    public ResponseEntity getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return answerHandler.getAll(page, size);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get answer By Id")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id) {
        return answerHandler.getById(id);
    }

    @PostMapping
    @Operation(summary = "Add New answer")
    public ResponseEntity save(@RequestBody AnswerDto dto) {
        return answerHandler.save(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update A answer")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody AnswerDto dto) {
        return answerHandler.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete A answer")
    public ResponseEntity delete(@PathVariable Integer id) {
        return answerHandler.delete(id);
    }
}

