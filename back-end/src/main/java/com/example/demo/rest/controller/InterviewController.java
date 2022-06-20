package com.example.demo.rest.controller;

import com.example.demo.rest.dto.InterviewDto;
import com.example.demo.rest.handler.InterviewHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interview")
@AllArgsConstructor
@Tag(name = "interview", description = "REST API for interview")
public class InterviewController {

    private InterviewHandler interviewHandler;

    @GetMapping
    @Operation(summary = "get All interview ")
    public ResponseEntity getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return interviewHandler.getAll(page, size);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get interview By Id")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id) {
        return interviewHandler.getById(id);
    }

    @PostMapping
    @Operation(summary = "Add New interview")
    public ResponseEntity save(@RequestBody InterviewDto dto) {
        return interviewHandler.save(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update A interview")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody InterviewDto dto) {
        return interviewHandler.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete A interview")
    public ResponseEntity delete(@PathVariable Integer id) {
        return interviewHandler.delete(id);
    }
}

