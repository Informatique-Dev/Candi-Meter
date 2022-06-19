package com.example.demo.rest.controller;

import com.example.demo.rest.handler.DocumentHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/document")
@AllArgsConstructor
@Tag(name = "document", description = "REST API for document")
public class DocumentController {

    private DocumentHandler documentHandler;

    @GetMapping("/{id}")
    @Operation(summary = "Get party By Id")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id) {
        return documentHandler.getById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete A party")
    public ResponseEntity delete(@PathVariable Integer id) {
        return documentHandler.delete(id);
    }

}
