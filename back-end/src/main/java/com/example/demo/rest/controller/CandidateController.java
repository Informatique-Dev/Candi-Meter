package com.example.demo.rest.controller;

import com.example.demo.rest.dto.CandidateDto;
import com.example.demo.rest.handler.CandidateHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
@AllArgsConstructor
@Tag(name = "candidate", description = "REST API for candidate")
public class CandidateController {
    private CandidateHandler candidateHandler;

    @GetMapping
    @Operation(summary = "get All candidate ")
    public ResponseEntity getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return candidateHandler.getAll(page, size);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get candidate By Id")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id) {
        return candidateHandler.getById(id);
    }

    @PostMapping
    @Operation(summary = "Add New candidate")
    public ResponseEntity save(@RequestBody CandidateDto dto) {
        return candidateHandler.save(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update A candidate")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody CandidateDto dto) {
        return candidateHandler.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete A candidate")
    public ResponseEntity delete(@PathVariable Integer id) {
        return candidateHandler.delete(id);
    }


}
