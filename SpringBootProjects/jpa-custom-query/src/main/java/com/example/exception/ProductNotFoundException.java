package com.example.exception;

/**
 * Exception thrown when a product is not found in the system.
 * 
 * This exception is used when attempting to retrieve a product by ID, name,
 * or other criteria but no matching product exists in the database.
 * 
 * @author Tamojeet
 * @version 1.0
 * @since 2024-12-19
 */
public class ProductNotFoundException extends RuntimeException {
    
    /**
     * Constructs a new ProductNotFoundException with the specified detail message.
     * 
     * @param message The detail message explaining why the product was not found
     */
    public ProductNotFoundException(String message) {
        super(message);
    }
    
    /**
     * Constructs a new ProductNotFoundException with the specified detail message and cause.
     * 
     * @param message The detail message explaining why the product was not found
     * @param cause The cause of the exception
     */
    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Constructs a new ProductNotFoundException with a formatted message for product by ID.
     * 
     * @param id The ID of the product that was not found
     * @return ProductNotFoundException with formatted message
     */
    public static ProductNotFoundException forId(Integer id) {
        return new ProductNotFoundException("Product not found with ID: " + id);
    }
    
    /**
     * Constructs a new ProductNotFoundException with a formatted message for product by name.
     * 
     * @param name The name of the product that was not found
     * @return ProductNotFoundException with formatted message
     */
    public static ProductNotFoundException forName(String name) {
        return new ProductNotFoundException("Product not found with name: " + name);
    }
    
    /**
     * Constructs a new ProductNotFoundException with a formatted message for product by name and price.
     * 
     * @param name The name of the product
     * @param price The price of the product
     * @return ProductNotFoundException with formatted message
     */
    public static ProductNotFoundException forNameAndPrice(String name, Double price) {
        return new ProductNotFoundException("Product not found with name: " + name + " and price: " + price);
    }
} 