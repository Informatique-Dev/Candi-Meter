package com.example.demo.rest.controller;

import com.example.demo.entity.FollowUp;
import com.example.demo.rest.dto.EmployeeDto;
import com.example.demo.rest.dto.FollowUpDto;
import com.example.demo.rest.handler.FollowUpHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/followUp")
@AllArgsConstructor
@Tag(name = "followUp", description = "REST API for followUp")
public class FollowUpController {
    private FollowUpHandler followUpHandler;

    @GetMapping("/{id}")
    @Operation(summary = "Get followUp By Id")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id) {
        return followUpHandler.getById(id);
    }

    @GetMapping("/{id}/followUp-interview")
    @Operation(summary = "get All interview by  FollowUp")
    public ResponseEntity getInterviews(@PathVariable(value = "id") Integer id, @RequestParam(value = "page", defaultValue = "0") Integer page,
                                      @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return followUpHandler.getAllByInterview(id, page, size);}

    @PostMapping
    @Operation(summary = "Add New followUp")
    public ResponseEntity save(@RequestBody FollowUpDto dto) {
        return followUpHandler.save(dto);
    }



    @DeleteMapping("/{id}")
    @Operation(summary = "Delete A followUp")
    public ResponseEntity delete(@PathVariable Integer id) {
        return followUpHandler.delete(id);
    }

}
