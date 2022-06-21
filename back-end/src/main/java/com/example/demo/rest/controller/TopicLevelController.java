package com.example.demo.rest.controller;


import com.example.demo.rest.dto.TopicLevelDto;

import com.example.demo.rest.handler.TopicLevelHandler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/topic-level")
@AllArgsConstructor
@Tag(name = "topic-level", description = "REST API for topic-level")
public class TopicLevelController {
    private TopicLevelHandler topicLevelHandler;

    @GetMapping
    @Operation(summary = "get All topic-level ")
    public ResponseEntity getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return topicLevelHandler.getAll(page, size);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get topic-level By Id")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id) {
        return topicLevelHandler.getById(id);
    }

    @PostMapping
    @Operation(summary = "Add New topic-level")
    public ResponseEntity save(@RequestBody TopicLevelDto dto) {
        return topicLevelHandler.save(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update A topic-level")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody TopicLevelDto dto) {
        return topicLevelHandler.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete A topic-level")
    public ResponseEntity delete(@PathVariable Integer id) {
        return topicLevelHandler.delete(id);
    }
}
