package com.example.demo.rest.controller;


import com.example.demo.rest.dto.TopicLevelDto;

import com.example.demo.rest.handler.TopicLevelHandler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/topiclevel")
@AllArgsConstructor
@Tag(name = "topiclevel", description = "REST API for topiclevel")
public class TopicLevelController {
    private TopicLevelHandler topicLevelHandler;

    @GetMapping
    @Operation(summary = "get All topiclevel ")
    public ResponseEntity getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return topicLevelHandler.getAll(page, size);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get topiclevel By Id")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id) {
        return topicLevelHandler.getById(id);
    }

    @PostMapping
    @Operation(summary = "Add New topiclevel")
    public ResponseEntity save(@RequestBody TopicLevelDto dto) {
        return topicLevelHandler.save(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update A topiclevel")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody TopicLevelDto dto) {
        return topicLevelHandler.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete A topiclevel")
    public ResponseEntity delete(@PathVariable Integer id) {
        return topicLevelHandler.delete(id);
    }
}
