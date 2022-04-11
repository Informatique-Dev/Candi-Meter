package com.example.demo.rest.controller;

import com.example.demo.rest.dto.EmployeeDto;
import com.example.demo.rest.dto.VacancyDto;
import com.example.demo.rest.handler.EmployeeHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
@Tag(name = "employee", description = "REST API for employee")
public class EmployeeController {
    private EmployeeHandler employeeHandler;

    @GetMapping
    @Operation(summary = "get All employee ")
    public ResponseEntity getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return employeeHandler.getAll(page, size);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get employee By Id")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id) {
        return employeeHandler.getById(id);
    }

    @PostMapping
    @Operation(summary = "Add New employee")
    public ResponseEntity save(@RequestBody EmployeeDto dto) {
        return employeeHandler.save(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update A employee")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody EmployeeDto dto) {
        return employeeHandler.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete A employee")
    public ResponseEntity delete(@PathVariable Integer id) {
        return employeeHandler.delete(id);
    }
}
