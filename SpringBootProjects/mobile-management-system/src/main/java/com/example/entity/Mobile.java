package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "mobiledata")
public class Mobile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String brand;
    @Column(unique = true,nullable = false)
    private String model;
    @Column(name = "price",nullable = false)
    private Double price;
    @Column(unique = true,nullable = false)
    private Integer stock;

    public Mobile(String brand, String model, Double price, Integer stock) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.stock = stock;
    }
}
