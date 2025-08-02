package com.example.service;

import com.example.entity.Product;
import com.example.exception.DatabaseOperationException;
import com.example.exception.InvalidInputException;
import com.example.exception.ProductNotFoundException;
import com.example.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer for Product entity providing business logic operations.
 * <p>
 * This service class acts as an intermediary between the controller and repository layers,
 * encapsulating business logic and providing a clean API for product-related operations.
 * The service delegates data access operations to the ProductRepository while potentially
 * adding business logic, validation, or transformation as needed.
 * 
 * @author Tamojeet
 * @version 1.0
 * @since 2024-12-19
 */
@Service
@AllArgsConstructor
public class ProductService {

    /**
     * Repository for product data access operations.
     * Injected via constructor using Lombok's @AllArgsConstructor.
     */
    private ProductRepository productRepository;

    /**
     * Retrieves all products from the database.
     * 
     * @return List of all products in the system
     * @throws DatabaseOperationException if database operation fails
     */
    public List<Product> getAll(){
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            throw DatabaseOperationException.forQueryFailure("getAll", e);
        }
    }

    /**
     * Retrieves a product by its exact name.
     * 
     * @param name The exact name of the product to find
     * @return Product with the specified name
     * @throws ProductNotFoundException if product is not found
     * @throws InvalidInputException if name is null or empty
     * @throws DatabaseOperationException if database operation fails
     */
    public Product getAProductByName(String name){
        if (name == null || name.trim().isEmpty()) {
            throw InvalidInputException.forEmptyParameter("name");
        }
        
        try {
            Product product = productRepository.findByName(name);
            if (product == null) {
                throw ProductNotFoundException.forName(name);
            }
            return product;
        } catch (ProductNotFoundException | InvalidInputException e) {
            throw e;
        } catch (Exception e) {
            throw DatabaseOperationException.forQueryFailure("findByName", e);
        }
    }

    /**
     * Retrieves a product by both name and price.
     * 
     * @param name The exact name of the product
     * @param price The exact price of the product
     * @return Product matching both name and price
     * @throws ProductNotFoundException if product is not found
     * @throws InvalidInputException if parameters are invalid
     * @throws DatabaseOperationException if database operation fails
     */
    public Product findByNameAndPrice(String name, Double price){
        if (name == null || name.trim().isEmpty()) {
            throw InvalidInputException.forEmptyParameter("name");
        }
        if (price == null || price < 0) {
            throw InvalidInputException.forNegativePrice(price);
        }
        
        try {
            Product product = productRepository.findByNameAndPrice(name, price);
            if (product == null) {
                throw ProductNotFoundException.forNameAndPrice(name, price);
            }
            return product;
        } catch (ProductNotFoundException | InvalidInputException e) {
            throw e;
        } catch (Exception e) {
            throw DatabaseOperationException.forQueryFailure("findByNameAndPrice", e);
        }
    }

    /**
     * Retrieves all products with a specific price.
     * 
     * @param price The price to search for
     * @return List of products with the specified price
     * @throws InvalidInputException if price is null or negative
     * @throws DatabaseOperationException if database operation fails
     */
    public List<Product> findByPrice(Double price){
        if (price == null || price < 0) {
            throw InvalidInputException.forNegativePrice(price);
        }
        
        try {
            return productRepository.findByPrice(price);
        } catch (InvalidInputException e) {
            throw e;
        } catch (Exception e) {
            throw DatabaseOperationException.forQueryFailure("findByPrice", e);
        }
    }

    /**
     * Retrieves all products with price greater than the specified value.
     * 
     * @param price The minimum price threshold
     * @return List of products with price greater than the specified value
     * @throws InvalidInputException if price is null or negative
     * @throws DatabaseOperationException if database operation fails
     */
    public List<Product> findByPriceGreaterThan(Double price) {
        if (price == null || price < 0) {
            throw InvalidInputException.forNegativePrice(price);
        }
        
        try {
            return productRepository.findByPriceGreaterThan(price);
        } catch (InvalidInputException e) {
            throw e;
        } catch (Exception e) {
            throw DatabaseOperationException.forQueryFailure("findByPriceGreaterThan", e);
        }
    }

    /**
     * Retrieves all products with price less than the specified value.
     * 
     * @param price The maximum price threshold
     * @return List of products with price less than the specified value
     * @throws InvalidInputException if price is null or negative
     * @throws DatabaseOperationException if database operation fails
     */
    public List<Product> findByPriceLessThan(Double price) {
        if (price == null || price < 0) {
            throw InvalidInputException.forNegativePrice(price);
        }
        
        try {
            return productRepository.findByPriceLessThan(price);
        } catch (InvalidInputException e) {
            throw e;
        } catch (Exception e) {
            throw DatabaseOperationException.forQueryFailure("findByPriceLessThan", e);
        }
    }

    /**
     * Retrieves all products with price between the specified range (inclusive).
     * 
     * @param min The minimum price (inclusive)
     * @param max The maximum price (inclusive)
     * @return List of products within the specified price range
     * @throws InvalidInputException if price range is invalid
     * @throws DatabaseOperationException if database operation fails
     */
    public List<Product> findByPriceBetween(Double min, Double max) {
        if (min == null || max == null) {
            throw InvalidInputException.forEmptyParameter("price range");
        }
        if (min < 0 || max < 0) {
            throw InvalidInputException.forNegativePrice(Math.min(min, max));
        }
        if (min > max) {
            throw InvalidInputException.forInvalidPriceRange(min, max);
        }
        
        try {
            return productRepository.findByPriceBetween(min, max);
        } catch (InvalidInputException e) {
            throw e;
        } catch (Exception e) {
            throw DatabaseOperationException.forQueryFailure("findByPriceBetween", e);
        }
    }

    /**
     * Retrieves all products whose name contains the specified keyword.
     * 
     * @param keyword The keyword to search for in product names
     * @return List of products whose names contain the keyword
     * @throws InvalidInputException if keyword is null or empty
     * @throws DatabaseOperationException if database operation fails
     */
    public List<Product> findByNameContaining(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            throw InvalidInputException.forEmptyParameter("keyword");
        }
        
        try {
            return productRepository.findByNameContaining(keyword);
        } catch (InvalidInputException e) {
            throw e;
        } catch (Exception e) {
            throw DatabaseOperationException.forQueryFailure("findByNameContaining", e);
        }
    }

    /**
     * Retrieves all products whose name starts with the specified prefix.
     * 
     * @param prefix The prefix to search for
     * @return List of products whose names start with the prefix
     * @throws InvalidInputException if prefix is null or empty
     * @throws DatabaseOperationException if database operation fails
     */
    public List<Product> findByNameStartingWith(String prefix) {
        if (prefix == null || prefix.trim().isEmpty()) {
            throw InvalidInputException.forEmptyParameter("prefix");
        }
        
        try {
            return productRepository.findByNameStartingWith(prefix);
        } catch (InvalidInputException e) {
            throw e;
        } catch (Exception e) {
            throw DatabaseOperationException.forQueryFailure("findByNameStartingWith", e);
        }
    }

    /**
     * Retrieves all products whose name ends with the specified suffix.
     * 
     * @param suffix The suffix to search for
     * @return List of products whose names end with the suffix
     * @throws InvalidInputException if suffix is null or empty
     * @throws DatabaseOperationException if database operation fails
     */
    public List<Product> findByNameEndingWith(String suffix) {
        if (suffix == null || suffix.trim().isEmpty()) {
            throw InvalidInputException.forEmptyParameter("suffix");
        }
        
        try {
            return productRepository.findByNameEndingWith(suffix);
        } catch (InvalidInputException e) {
            throw e;
        } catch (Exception e) {
            throw DatabaseOperationException.forQueryFailure("findByNameEndingWith", e);
        }
    }

    /**
     * Retrieves all products whose name contains the specified keyword and price is greater than the specified value.
     * 
     * @param name The keyword to search for in product names
     * @param price The minimum price threshold
     * @return List of products matching both criteria
     * @throws InvalidInputException if parameters are invalid
     * @throws DatabaseOperationException if database operation fails
     */
    public List<Product> findByNameContainingAndPriceGreaterThan(String name, Double price) {
        if (name == null || name.trim().isEmpty()) {
            throw InvalidInputException.forEmptyParameter("name");
        }
        if (price == null || price < 0) {
            throw InvalidInputException.forNegativePrice(price);
        }
        
        try {
            return productRepository.findByNameContainingAndPriceGreaterThan(name, price);
        } catch (InvalidInputException e) {
            throw e;
        } catch (Exception e) {
            throw DatabaseOperationException.forQueryFailure("findByNameContainingAndPriceGreaterThan", e);
        }
    }

    /**
     * Retrieves all products whose name is in the specified list and price is within the specified range.
     * 
     * @param names List of product names to search for
     * @param min The minimum price (inclusive)
     * @param max The maximum price (inclusive)
     * @return List of products matching both criteria
     * @throws InvalidInputException if parameters are invalid
     * @throws DatabaseOperationException if database operation fails
     */
    public List<Product> findByNameInAndPriceBetween(List<String> names, Double min, Double max) {
        if (names == null || names.isEmpty()) {
            throw InvalidInputException.forEmptyList("names");
        }
        if (min == null || max == null) {
            throw InvalidInputException.forEmptyParameter("price range");
        }
        if (min < 0 || max < 0) {
            throw InvalidInputException.forNegativePrice(Math.min(min, max));
        }
        if (min > max) {
            throw InvalidInputException.forInvalidPriceRange(min, max);
        }
        
        try {
            return productRepository.findByNameInAndPriceBetween(names, min, max);
        } catch (InvalidInputException e) {
            throw e;
        } catch (Exception e) {
            throw DatabaseOperationException.forQueryFailure("findByNameInAndPriceBetween", e);
        }
    }

    /**
     * Retrieves all products with the specified name (case-insensitive search).
     * 
     * @param name The name to search for (case-insensitive)
     * @return List of products with the specified name (ignoring case)
     * @throws InvalidInputException if name is null or empty
     * @throws DatabaseOperationException if database operation fails
     */
    public List<Product> findByNameIgnoreCase(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw InvalidInputException.forEmptyParameter("name");
        }
        
        try {
            return productRepository.findByNameIgnoreCase(name);
        } catch (InvalidInputException e) {
            throw e;
        } catch (Exception e) {
            throw DatabaseOperationException.forQueryFailure("findByNameIgnoreCase", e);
        }
    }

    /**
     * Retrieves all products ordered by price in ascending order.
     * 
     * @return List of all products sorted by price (lowest to highest)
     * @throws DatabaseOperationException if database operation fails
     */
    public List<Product> findAllByOrderByPriceAsc() {
        try {
            return productRepository.findAllByOrderByPriceAsc();
        } catch (Exception e) {
            throw DatabaseOperationException.forQueryFailure("findAllByOrderByPriceAsc", e);
        }
    }

    /**
     * Retrieves all products ordered by price in descending order.
     * 
     * @return List of all products sorted by price (highest to lowest)
     * @throws DatabaseOperationException if database operation fails
     */
    public List<Product> findAllByOrderByPriceDesc() {
        try {
            return productRepository.findAllByOrderByPriceDesc();
        } catch (Exception e) {
            throw DatabaseOperationException.forQueryFailure("findAllByOrderByPriceDesc", e);
        }
    }

    /**
     * Retrieves all products whose name contains the specified keyword, ordered by price in ascending order.
     * 
     * @param keyword The keyword to search for in product names
     * @return List of matching products sorted by price (lowest to highest)
     * @throws InvalidInputException if keyword is null or empty
     * @throws DatabaseOperationException if database operation fails
     */
    public List<Product> findByNameContainingOrderByPriceAsc(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            throw InvalidInputException.forEmptyParameter("keyword");
        }
        
        try {
            return productRepository.findByNameContainingOrderByPriceAsc(keyword);
        } catch (InvalidInputException e) {
            throw e;
        } catch (Exception e) {
            throw DatabaseOperationException.forQueryFailure("findByNameContainingOrderByPriceAsc", e);
        }
    }

    /**
     * Retrieves all products within a specific price range using custom JPQL query.
     * 
     * @param minPrice The minimum price (inclusive)
     * @param maxPrice The maximum price (inclusive)
     * @return List of products within the specified price range
     * @throws InvalidInputException if price range is invalid
     * @throws DatabaseOperationException if database operation fails
     */
    public List<Product> searchByPriceRange(Double minPrice, Double maxPrice) {
        if (minPrice == null || maxPrice == null) {
            throw InvalidInputException.forEmptyParameter("price range");
        }
        if (minPrice < 0 || maxPrice < 0) {
            throw InvalidInputException.forNegativePrice(Math.min(minPrice, maxPrice));
        }
        if (minPrice > maxPrice) {
            throw InvalidInputException.forInvalidPriceRange(minPrice, maxPrice);
        }
        
        try {
            return productRepository.searchByPriceRange(minPrice, maxPrice);
        } catch (InvalidInputException e) {
            throw e;
        } catch (Exception e) {
            throw DatabaseOperationException.forQueryFailure("searchByPriceRange", e);
        }
    }
}
