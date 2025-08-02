package com.example.exception;

/**
 * Exception thrown when invalid input parameters are provided.
 * 
 * This exception is used when request parameters are invalid, such as:
 * - Empty or null search keywords
 * - Invalid price ranges (min > max)
 * - Negative prices
 * - Malformed request data
 * 
 * @author Tamojeet
 * @version 1.0
 * @since 2024-12-19
 */
public class InvalidInputException extends RuntimeException {
    
    /**
     * Constructs a new InvalidInputException with the specified detail message.
     * 
     * @param message The detail message explaining the invalid input
     */
    public InvalidInputException(String message) {
        super(message);
    }
    
    /**
     * Constructs a new InvalidInputException with the specified detail message and cause.
     * 
     * @param message The detail message explaining the invalid input
     * @param cause The cause of the exception
     */
    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Constructs a new InvalidInputException for empty or null search keyword.
     * 
     * @param parameterName The name of the parameter that is empty
     * @return InvalidInputException with formatted message
     */
    public static InvalidInputException forEmptyParameter(String parameterName) {
        return new InvalidInputException("Parameter '" + parameterName + "' cannot be empty or null");
    }
    
    /**
     * Constructs a new InvalidInputException for invalid price range.
     * 
     * @param minPrice The minimum price
     * @param maxPrice The maximum price
     * @return InvalidInputException with formatted message
     */
    public static InvalidInputException forInvalidPriceRange(Double minPrice, Double maxPrice) {
        return new InvalidInputException("Invalid price range: min (" + minPrice + ") cannot be greater than max (" + maxPrice + ")");
    }
    
    /**
     * Constructs a new InvalidInputException for negative price.
     * 
     * @param price The negative price value
     * @return InvalidInputException with formatted message
     */
    public static InvalidInputException forNegativePrice(Double price) {
        return new InvalidInputException("Price cannot be negative: " + price);
    }
    
    /**
     * Constructs a new InvalidInputException for empty list parameter.
     * 
     * @param parameterName The name of the list parameter
     * @return InvalidInputException with formatted message
     */
    public static InvalidInputException forEmptyList(String parameterName) {
        return new InvalidInputException("List parameter '" + parameterName + "' cannot be empty or null");
    }
} 