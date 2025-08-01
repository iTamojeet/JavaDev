package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot Application class for JPA Custom Query demonstration.
 * 
 * This application demonstrates various JPA query methods including:
 * - Spring Data JPA method naming conventions
 * - Custom @Query annotations
 * - Different types of database operations (find, search, sort)
 * 
 * The application provides REST endpoints to showcase different query patterns
 * for product management operations.
 * 
 * @author Tamojeet
 * @version 1.0
 * @since 2024-12-19
 */
@SpringBootApplication
public class JpaCustomQueryApplication {

    /**
     * Main method to bootstrap the Spring Boot application.
     * 
     * @param args Command line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(JpaCustomQueryApplication.class, args);
    }

}
