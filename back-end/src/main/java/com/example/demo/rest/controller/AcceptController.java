package com.example.demo.rest.controller;

import com.example.demo.rest.dto.AcceptDto;
import com.example.demo.rest.dto.CompanyDto;
import com.example.demo.rest.handler.AcceptHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accept")
@AllArgsConstructor
@Tag(name = "accept", description = "REST API for accept")
public class AcceptController {
    private AcceptHandler acceptHandler;


    @GetMapping
    @Operation(summary = "get All accept ")
    public ResponseEntity getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return acceptHandler.getAll(page, size);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get accept By Id")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id) {
        return acceptHandler.getById(id);
    }

    @PostMapping
    @Operation(summary = "Add New accept")
    public ResponseEntity save(@RequestBody AcceptDto dto) {
        return acceptHandler.save(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update A accept")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody AcceptDto dto) {
        return acceptHandler.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete A accept")
    public ResponseEntity delete(@PathVariable Integer id) {
        return acceptHandler.delete(id);
    }
}
