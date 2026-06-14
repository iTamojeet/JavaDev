package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor@Data
public class AddressDto {
    @NotBlank(message = "city is required")
    @Pattern(regexp = "^[A-Za-z]+$", message = "city must contain alphabets")
    private String city;
    @NotBlank(message = "state is required")
    @Pattern(regexp = "^[A-Za-z]+$", message = "state must contain alphabets")
    private String state;
    @NotBlank(message = "pin code is required")
    @Pattern(regexp = "^[0-9]{6}$", message = "pin code must be 6 digits")
    private String pin_code;
}
