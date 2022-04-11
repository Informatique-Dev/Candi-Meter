package com.example.demo.rest.controller;


import com.example.demo.rest.dto.TopicsDto;
import com.example.demo.rest.handler.TopicsHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/topics")
@AllArgsConstructor
@Tag(name = "topics", description = "REST API for topics")
public class TopicsController {

    private TopicsHandler topicsHandler;

    @GetMapping
    @Operation(summary = "get All topics ")
    public ResponseEntity getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return topicsHandler.getAll(page, size);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get topic By Id")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id) {
        return topicsHandler.getById(id);
    }

    @PostMapping
    @Operation(summary = "Add New topic")
    public ResponseEntity save(@RequestBody TopicsDto dto) {
        return topicsHandler.save(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update A topic")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody TopicsDto dto) {
        return topicsHandler.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete A topic")
    public ResponseEntity delete(@PathVariable Integer id) {
        return topicsHandler.delete(id);
    }
}
