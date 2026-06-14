package com.example.controller;

import com.example.dto.UserDto;
import com.example.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    @PostMapping
    public UserDto saveUser(@Valid @RequestBody UserDto dto) {

        return service.saveUser(dto);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {

        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {

        return service.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id,@Valid @RequestBody UserDto dto) {

        return service.updateUser(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(
            @PathVariable Long id) {

        service.deleteUser(id);
    }


}