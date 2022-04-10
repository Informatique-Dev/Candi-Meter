package com.example.demo.rest.controller;


import com.example.demo.rest.dto.ApplicationDto;
import com.example.demo.rest.handler.ApplicationHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/application")
@AllArgsConstructor
@Tag(name = "application", description = "REST API for application")
public class ApplicationController {
   private ApplicationHandler applicationHandler;


    @GetMapping
    @Operation(summary = "get All application ")
    public ResponseEntity getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return applicationHandler.getAll(page, size);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get application By Id")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id) {
        return applicationHandler.getById(id);
    }

    @PostMapping
    @Operation(summary = "Add New application")
    public ResponseEntity save(@RequestBody ApplicationDto dto) {
        return applicationHandler.save(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update A application")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody ApplicationDto dto) {
        return applicationHandler.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete A application")
    public ResponseEntity delete(@PathVariable Integer id) {
        return applicationHandler.delete(id);
    }


}

