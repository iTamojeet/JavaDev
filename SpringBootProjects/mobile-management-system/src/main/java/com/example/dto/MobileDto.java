package com.example.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record MobileDto(
        @NotBlank(message = "Brand must be there.")
        String brand,
        @NotBlank(message = "Model must be there.")
        String model,
        @Min(value = 1,message = "Price must be there and greater than ₹1")
        Double price,
        @Min(value = 1,message = "Stock must be greater than 1")
        Integer stock
) {
        public MobileDto {
        }
}
