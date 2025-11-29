package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String takeName(String name){
        return name.trim().toUpperCase();
    }
}
