package com.example.exception;

/**
 * Exception thrown when database operations fail.
 * 
 * This exception is used when database operations such as queries, transactions,
 * or data access operations fail due to database connectivity issues, constraint
 * violations, or other database-related problems.
 * 
 * @author Tamojeet
 * @version 1.0
 * @since 2024-12-19
 */
public class DatabaseOperationException extends RuntimeException {
    
    /**
     * Constructs a new DatabaseOperationException with the specified detail message.
     * 
     * @param message The detail message explaining the database operation failure
     */
    public DatabaseOperationException(String message) {
        super(message);
    }
    
    /**
     * Constructs a new DatabaseOperationException with the specified detail message and cause.
     * 
     * @param message The detail message explaining the database operation failure
     * @param cause The cause of the exception
     */
    public DatabaseOperationException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Constructs a new DatabaseOperationException for query execution failure.
     * 
     * @param operation The database operation that failed
     * @param cause The underlying database exception
     * @return DatabaseOperationException with formatted message
     */
    public static DatabaseOperationException forQueryFailure(String operation, Throwable cause) {
        return new DatabaseOperationException("Database query failed for operation: " + operation, cause);
    }
    
    /**
     * Constructs a new DatabaseOperationException for connection failure.
     * 
     * @param cause The underlying database connection exception
     * @return DatabaseOperationException with formatted message
     */
    public static DatabaseOperationException forConnectionFailure(Throwable cause) {
        return new DatabaseOperationException("Database connection failed", cause);
    }
    
    /**
     * Constructs a new DatabaseOperationException for transaction failure.
     * 
     * @param operation The transaction operation that failed
     * @param cause The underlying transaction exception
     * @return DatabaseOperationException with formatted message
     */
    public static DatabaseOperationException forTransactionFailure(String operation, Throwable cause) {
        return new DatabaseOperationException("Database transaction failed for operation: " + operation, cause);
    }
} 