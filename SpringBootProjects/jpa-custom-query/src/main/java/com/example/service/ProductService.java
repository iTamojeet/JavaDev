package com.example.service;

import com.example.entity.Product;
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
     */
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    /**
     * Retrieves a product by its exact name.
     * 
     * @param name The exact name of the product to find
     * @return Product with the specified name, or null if not found
     */
    public Product getAProductByName(String name){
        return productRepository.findByName(name);
    }

    /**
     * Retrieves a product by both name and price.
     * 
     * @param name The exact name of the product
     * @param price The exact price of the product
     * @return Product matching both name and price, or null if not found
     */
    public Product findByNameAndPrice(String name, Double price){
        return productRepository.findByNameAndPrice(name, price);
    }

    /**
     * Retrieves all products with a specific price.
     * 
     * @param price The price to search for
     * @return List of products with the specified price
     */
    public List<Product> findByPrice(Double price){
        return productRepository.findByPrice(price);
    }

    /**
     * Retrieves all products with price greater than the specified value.
     * 
     * @param price The minimum price threshold
     * @return List of products with price greater than the specified value
     */
    public List<Product> findByPriceGreaterThan(Double price) {
        return productRepository.findByPriceGreaterThan(price);
    }

    /**
     * Retrieves all products with price less than the specified value.
     * 
     * @param price The maximum price threshold
     * @return List of products with price less than the specified value
     */
    public List<Product> findByPriceLessThan(Double price) {
        return productRepository.findByPriceLessThan(price);
    }

    /**
     * Retrieves all products with price between the specified range (inclusive).
     * 
     * @param min The minimum price (inclusive)
     * @param max The maximum price (inclusive)
     * @return List of products within the specified price range
     */
    public List<Product> findByPriceBetween(Double min, Double max) {
        return productRepository.findByPriceBetween(min, max);
    }

    /**
     * Retrieves all products whose name contains the specified keyword.
     * 
     * @param keyword The keyword to search for in product names
     * @return List of products whose names contain the keyword
     */
    public List<Product> findByNameContaining(String keyword) {
        return productRepository.findByNameContaining(keyword);
    }

    /**
     * Retrieves all products whose name starts with the specified prefix.
     * 
     * @param prefix The prefix to search for
     * @return List of products whose names start with the prefix
     */
    public List<Product> findByNameStartingWith(String prefix) {
        return productRepository.findByNameStartingWith(prefix);
    }

    /**
     * Retrieves all products whose name ends with the specified suffix.
     * 
     * @param suffix The suffix to search for
     * @return List of products whose names end with the suffix
     */
    public List<Product> findByNameEndingWith(String suffix) {
        return productRepository.findByNameEndingWith(suffix);
    }

    /**
     * Retrieves all products whose name contains the specified keyword and price is greater than the specified value.
     * 
     * @param name The keyword to search for in product names
     * @param price The minimum price threshold
     * @return List of products matching both criteria
     */
    public List<Product> findByNameContainingAndPriceGreaterThan(String name, Double price) {
        return productRepository.findByNameContainingAndPriceGreaterThan(name, price);
    }

    /**
     * Retrieves all products whose name is in the specified list and price is within the specified range.
     * 
     * @param names List of product names to search for
     * @param min The minimum price (inclusive)
     * @param max The maximum price (inclusive)
     * @return List of products matching both criteria
     */
    public List<Product> findByNameInAndPriceBetween(List<String> names, Double min, Double max) {
        return productRepository.findByNameInAndPriceBetween(names, min, max);
    }

    /**
     * Retrieves all products with the specified name (case-insensitive search).
     * 
     * @param name The name to search for (case-insensitive)
     * @return List of products with the specified name (ignoring case)
     */
    public List<Product> findByNameIgnoreCase(String name) {
        return productRepository.findByNameIgnoreCase(name);
    }

    /**
     * Retrieves all products ordered by price in ascending order.
     * 
     * @return List of all products sorted by price (lowest to highest)
     */
    public List<Product> findAllByOrderByPriceAsc() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    /**
     * Retrieves all products ordered by price in descending order.
     * 
     * @return List of all products sorted by price (highest to lowest)
     */
    public List<Product> findAllByOrderByPriceDesc() {
        return productRepository.findAllByOrderByPriceDesc();
    }

    /**
     * Retrieves all products whose name contains the specified keyword, ordered by price in ascending order.
     * 
     * @param keyword The keyword to search for in product names
     * @return List of matching products sorted by price (lowest to highest)
     */
    public List<Product> findByNameContainingOrderByPriceAsc(String keyword) {
        return productRepository.findByNameContainingOrderByPriceAsc(keyword);
    }

    /**
     * Retrieves all products within a specific price range using custom JPQL query.
     * 
     * @param minPrice The minimum price (inclusive)
     * @param maxPrice The maximum price (inclusive)
     * @return List of products within the specified price range
     */
    public List<Product> searchByPriceRange(Double minPrice, Double maxPrice) {
        return productRepository.searchByPriceRange(minPrice, maxPrice);
    }
}
