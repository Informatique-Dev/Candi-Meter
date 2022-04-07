package com.example.demo.rest.controller;


import com.example.demo.rest.dto.PositionDto;

import com.example.demo.rest.handler.PositionHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
@AllArgsConstructor
@Tag(name = "position", description = "REST API for position")
public class PositionController {
    private PositionHandler positionHandler;

    @GetMapping
    @Operation(summary = "get All position ")
    public ResponseEntity getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return positionHandler.getAll(page, size);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get position By Id")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id) {
        return positionHandler.getById(id);
    }

    @PostMapping
    @Operation(summary = "Add New position")
    public ResponseEntity save(@RequestBody PositionDto dto) {
        return positionHandler.save(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update A position")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody PositionDto dto) {
        return positionHandler.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete A position")
    public ResponseEntity delete(@PathVariable Integer id) {
        return positionHandler.delete(id);
    }
}