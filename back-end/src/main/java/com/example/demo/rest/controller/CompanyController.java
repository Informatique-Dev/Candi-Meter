package com.example.demo.rest.controller;

import com.example.demo.rest.dto.CompanyDto;
import com.example.demo.rest.handler.CompanyHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
@Tag(name = "company", description = "REST API for company")
public class CompanyController {

    private CompanyHandler companyHandler;

    @GetMapping
    @Operation(summary = "get All company ")
    public ResponseEntity getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return companyHandler.getAll(page, size);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get company By Id")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id) {
        return companyHandler.getById(id);
    }

    @PostMapping
    @Operation(summary = "Add New company")
    public ResponseEntity save(@RequestBody CompanyDto dto) {
        return companyHandler.save(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update A company")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody CompanyDto dto) {
        return companyHandler.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete A company")
    public ResponseEntity delete(@PathVariable Integer id) {
        return companyHandler.delete(id);
    }
}
