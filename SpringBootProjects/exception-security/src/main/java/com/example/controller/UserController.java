package com.example.controller;

import com.example.dto.UserDto;
import com.example.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Generated;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> controllerAll(){
        return ResponseEntity.ok(
                userService.seeAll()
        );
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<UserDto>> controllerByEmail(@PathVariable String email){
        return ResponseEntity.ok(
                userService.getByEmail(email)
        );
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserDto> controllerById(@PathVariable Integer id){
        return ResponseEntity.ok(
                userService.seeOne(id)
        );
    }
}
