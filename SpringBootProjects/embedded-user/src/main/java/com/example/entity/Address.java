package com.example.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
