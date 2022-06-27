package com.example.demo.rest.controller;

import com.example.demo.rest.dto.TopicRateDto;
import com.example.demo.rest.handler.TopicRateHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicrate")
@AllArgsConstructor
@Tag(name = "topicrate", description = "REST API for topicrate")
public class TopicRateController {

    private TopicRateHandler topicRateHandler;

    @GetMapping
    @Operation(summary = "get All topicrate ")
    public ResponseEntity getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return topicRateHandler.getAll(page, size);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get topicrate By Id")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id) {
        return topicRateHandler.getById(id);
    }

    @PostMapping
    @Operation(summary = "Add New topicrate")
    public ResponseEntity save(@RequestBody TopicRateDto dto) {
        return topicRateHandler.save(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update A topicrate")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody TopicRateDto dto) {
        return topicRateHandler.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete A topicrate")
    public ResponseEntity delete(@PathVariable Integer id) {
        return topicRateHandler.delete(id);
    }
}

