package com.example.service;

import com.example.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> seeAll(); // public/general REST API
    UserDto seeOne(int id); // User role REST API
    List<UserDto> getByEmail(String email);// Admin role REST API
}
