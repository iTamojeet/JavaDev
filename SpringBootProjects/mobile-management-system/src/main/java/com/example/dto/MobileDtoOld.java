package com.example.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MobileDtoOld {
    private Long id;
    @NotBlank(message = "Brand must be there.")
    private String brand;
    @NotBlank(message = "Model must be there.")
    private String model;
    @Min(value = 1,message = "Price must be there and greater than ₹1")
    private Double price;
    @Min(value = 1,message = "Stock must be greater than 1")
    private Integer stock;
}
