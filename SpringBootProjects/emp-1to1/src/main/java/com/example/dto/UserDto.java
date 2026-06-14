package com.example.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor@Data
public class UserDto {
    @NotBlank(message = "name is required")
    @Pattern(regexp = "^[A-Za-z]+$", message = "name must contain alphabets")
    private String full_name;
    @NotBlank(message = "email is required")
    @Email(message = "invalid email")
    private String email;
    @NotBlank(message = "phone is required")
    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "indian phone must contain 10 digits")
    private String phone;
    @Min(value = 18, message = "Minimum age must be 18")
    @Max(value = 60, message = "Maximum age must be 60")
    private Integer age;
    @Valid
    private AddressDto addressDto;
}
