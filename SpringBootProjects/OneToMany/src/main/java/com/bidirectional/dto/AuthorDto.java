package com.bidirectional.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthorDto {
    @NotBlank
    @Pattern(regexp = "^[A-Za-z]{3,50}$", message = "Jali author name")
    private String authorName;
    @Email(message = "Jali email ID")
    private String email;
}
