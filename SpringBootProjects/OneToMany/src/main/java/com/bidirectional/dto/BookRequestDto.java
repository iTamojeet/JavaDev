package com.bidirectional.dto;

import com.bidirectional.entity.Author;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookRequestDto {
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9]{3,100}$", message = "Jali book tile")
    private String title;
    @DecimalMin("100.25")
    private Double price;
    @Pattern(regexp = "^[A-Za-z]+$", message = "Jali book category")
    private String category;
    @Valid
    private List<Author> authors;
}
