package com.example.demo.rest.controller;

import com.example.demo.rest.dto.VacancyDto;
import com.example.demo.rest.handler.VacancyHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vacancy")
@AllArgsConstructor
@Tag(name = "vacancy", description = "REST API for vacancy")
public class VacancyController {

    private VacancyHandler vacancyHandler;

    @GetMapping
    @Operation(summary = "get All vacancy ")
    public ResponseEntity getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return vacancyHandler.getAll(page, size);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get vacancy By Id")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id) {
        return vacancyHandler.getById(id);
    }

    @PostMapping
    @Operation(summary = "Add New vacancy")
    public ResponseEntity save(@RequestBody VacancyDto dto) {
        return vacancyHandler.save(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update A vacancy")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody VacancyDto dto) {
        return vacancyHandler.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete A vacancy")
    public ResponseEntity delete(@PathVariable Integer id) {
        return vacancyHandler.delete(id);
    }
}
