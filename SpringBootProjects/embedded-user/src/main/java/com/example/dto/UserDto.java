package com.example.dto;

import com.example.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDto(
        Long id,
        @NotBlank(message = "Name required")
        String name,
        @Email(message = "Thik email dao.")
        String email,
        String street,
        String city,
        String state,
        String zipCode
) {

}
