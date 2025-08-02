package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler for the application.
 * 
 * This class provides centralized exception handling for all controllers,
 * ensuring consistent error responses across the application. It handles
 * various types of exceptions and returns appropriate HTTP status codes
 * with meaningful error messages.
 * 
 * @author Tamojeet
 * @version 1.0
 * @since 2024-12-19
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles ProductNotFoundException for when products are not found.
     * 
     * @param ex The ProductNotFoundException that occurred
     * @param request The web request that caused the exception
     * @return ResponseEntity with error details and 404 status code
     */
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("message", "Product not found");
        errorDetails.put("details", ex.getMessage());
        errorDetails.put("path", request.getDescription(false));
        errorDetails.put("errorType", "ProductNotFoundException");
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    /**
     * Handles InvalidInputException for invalid input parameters.
     * 
     * @param ex The InvalidInputException that occurred
     * @param request The web request that caused the exception
     * @return ResponseEntity with error details and 400 status code
     */
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidInputException(InvalidInputException ex, WebRequest request) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("message", "Invalid input parameters");
        errorDetails.put("details", ex.getMessage());
        errorDetails.put("path", request.getDescription(false));
        errorDetails.put("errorType", "InvalidInputException");
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    /**
     * Handles DatabaseOperationException for database operation failures.
     * 
     * @param ex The DatabaseOperationException that occurred
     * @param request The web request that caused the exception
     * @return ResponseEntity with error details and 500 status code
     */
    @ExceptionHandler(DatabaseOperationException.class)
    public ResponseEntity<Map<String, Object>> handleDatabaseOperationException(DatabaseOperationException ex, WebRequest request) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("message", "Database operation failed");
        errorDetails.put("details", ex.getMessage());
        errorDetails.put("path", request.getDescription(false));
        errorDetails.put("errorType", "DatabaseOperationException");
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }

    /**
     * Handles IllegalArgumentException for invalid input parameters.
     * 
     * @param ex The IllegalArgumentException that occurred
     * @param request The web request that caused the exception
     * @return ResponseEntity with error details and 400 status code
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("message", "Invalid input parameters");
        errorDetails.put("details", ex.getMessage());
        errorDetails.put("path", request.getDescription(false));
        errorDetails.put("errorType", "IllegalArgumentException");
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    /**
     * Handles NullPointerException for null references.
     * 
     * @param ex The NullPointerException that occurred
     * @param request The web request that caused the exception
     * @return ResponseEntity with error details and 400 status code
     */
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Map<String, Object>> handleNullPointerException(NullPointerException ex, WebRequest request) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("message", "Required parameter is missing");
        errorDetails.put("details", "One or more required parameters are null");
        errorDetails.put("path", request.getDescription(false));
        errorDetails.put("errorType", "NullPointerException");
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    /**
     * Handles general exceptions that are not specifically caught.
     * 
     * @param ex The exception that occurred
     * @param request The web request that caused the exception
     * @return ResponseEntity with error details and 500 status code
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGlobalException(Exception ex, WebRequest request) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("message", "An unexpected error occurred");
        errorDetails.put("details", ex.getMessage());
        errorDetails.put("path", request.getDescription(false));
        errorDetails.put("errorType", "UnexpectedException");
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }
} 