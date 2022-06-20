package com.example.demo.rest.controller;

import com.example.demo.rest.dto.QuestionDto;
import com.example.demo.rest.handler.QuestionHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
@AllArgsConstructor
@Tag(name = "question", description = "REST API for question")
public class QuestionController {
    private QuestionHandler questionHandler;

    @GetMapping
    @Operation(summary = "get All questions ")
    public ResponseEntity getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return questionHandler.getAll(page, size);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get question By Id")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id) {
        return questionHandler.getById(id);
    }

    @PostMapping
    @Operation(summary = "Add New question")
    public ResponseEntity save(@RequestBody QuestionDto dto) {
        return questionHandler.save(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update A question")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody QuestionDto dto) {
        return questionHandler.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete A question")
    public ResponseEntity delete(@PathVariable Integer id) {
        return questionHandler.delete(id);
    }
}
