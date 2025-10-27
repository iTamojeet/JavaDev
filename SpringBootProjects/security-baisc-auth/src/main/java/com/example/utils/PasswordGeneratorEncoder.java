package com.example.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordGeneratorEncoder {
    void main(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        IO.println(passwordEncoder.encode("tamo"));
        IO.println(passwordEncoder.encode("admin"));
    }
}
