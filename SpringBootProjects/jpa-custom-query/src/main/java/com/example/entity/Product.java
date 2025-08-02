package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Product entity representing a product in the system.
 * 
 * This entity is mapped to the 'products' table in the database and contains
 * basic product information including id, name, and price. The class uses
 * Lombok annotations to reduce boilerplate code for constructors, getters,
 * setters, toString, equals, and hashCode methods.
 * 
 * @author Tamojeet
 * @version 1.0
 * @since 2024-12-19
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="products")
public class Product {
    
    /**
     * Unique identifier for the product.
     * This field serves as the primary key in the database.
     */
    @Id
    @NotNull(message = "Product ID cannot be null")
    private Integer id;
    
    /**
     * Name of the product.
     * This field stores the product name as a string.
     * Must not be blank and should be a valid product name.
     */
    @NotBlank(message = "Product name cannot be blank")
    private String name;
    
    /**
     * Price of the product.
     * This field stores the product price as a double value.
     * Must be positive and not null.
     */
    @NotNull(message = "Product price cannot be null")
    @Positive(message = "Product price must be positive")
    private Double price;
}
