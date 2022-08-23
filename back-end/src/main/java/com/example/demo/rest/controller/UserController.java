package com.example.demo.rest.controller;

import com.example.demo.rest.dto.UserDto;
import com.example.demo.rest.handler.UserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Tag(name = "user", description = "REST API for user")
public class UserController {
    private final UserHandler userHandler;

    @GetMapping
    @Operation(summary = "Get All Users Paged")
    public ResponseEntity<?> getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return ResponseEntity.ok(userHandler.getAll(page, size));
    }

    @PostMapping
    @Operation(summary = "add New User")
    public ResponseEntity<?> save(@RequestBody UserDto usersDto) {
        return userHandler.save(usersDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "get User By Id")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return userHandler.getById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete User By Id")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return userHandler.delete(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "update User")
    public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody UserDto usersDto) {
        return userHandler.update(id, usersDto);
    }
}
