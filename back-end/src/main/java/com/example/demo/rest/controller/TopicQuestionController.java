package com.example.demo.rest.controller;


import com.example.demo.rest.dto.TopicQuestionDto;
import com.example.demo.rest.handler.TopicQuestionHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicquestion")
@AllArgsConstructor
@Tag(name = "topicquestion", description = "REST API for topicquestion")
public class TopicQuestionController {

    private TopicQuestionHandler topicQuestionHandler;

    @GetMapping
    @Operation(summary = "get All topicquestion ")
    public ResponseEntity getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return topicQuestionHandler.getAll(page, size);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get topicquestion By Id")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id) {
        return topicQuestionHandler.getById(id);
    }

    @PostMapping
    @Operation(summary = "Add New topicquestion")
    public ResponseEntity save(@RequestBody TopicQuestionDto dto) {
        return topicQuestionHandler.save(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update A topicquestion")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody TopicQuestionDto dto) {
        return topicQuestionHandler.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete A topicquestion")
    public ResponseEntity delete(@PathVariable Integer id) {
        return topicQuestionHandler.delete(id);
    }
}
