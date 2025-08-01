package com.example.controller;

import com.example.entity.Product;
import com.example.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Product entity providing HTTP endpoints for product operations.
 * 
 * This controller exposes RESTful APIs for various product search and retrieval operations,
 * demonstrating different types of JPA queries through HTTP endpoints. The controller
 * handles HTTP requests and delegates business logic to the ProductService layer.
 * 
 * Base URL: /products
 * 
 * Available endpoints include:
 * - GET operations for retrieving products with various search criteria
 * - POST operations for complex search scenarios
 * - Support for path variables, request parameters, and request bodies
 * 
 * @author Tamojeet
 * @version 1.0
 * @since 2024-12-19
 */
@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    /**
     * Service layer for product business logic operations.
     * Injected via constructor using Lombok's @AllArgsConstructor.
     */
    private final ProductService productService;

    /**
     * Retrieves all products from the system.
     * 
     * @return List of all products
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    /**
     * Retrieves a product by its exact name.
     * 
     * @param name The exact name of the product (path variable)
     * @return Product with the specified name, or null if not found
     */
    @GetMapping("/name/{name}")
    public Product getProductByName(@PathVariable String name) {
        return productService.getAProductByName(name);
    }

    /**
     * Retrieves a product by both name and price using request parameters.
     * 
     * @param name The exact name of the product (request parameter)
     * @param price The exact price of the product (request parameter)
     * @return Product matching both name and price, or null if not found
     */
    @GetMapping("/name-price")
    public Product getProductByNameAndPrice(
            @RequestParam String name,
            @RequestParam Double price) {
        return productService.findByNameAndPrice(name, price);
    }

    /**
     * Retrieves all products with a specific price.
     * 
     * @param price The price to search for (request parameter)
     * @return List of products with the specified price
     */
    @GetMapping("/price")
    public List<Product> getByPrice(@RequestParam Double price) {
        return productService.findByPrice(price);
    }

    /**
     * Retrieves all products with price greater than the specified value.
     * 
     * @param price The minimum price threshold (request parameter)
     * @return List of products with price greater than the specified value
     */
    @GetMapping("/price/greater")
    public List<Product> getByPriceGreater(@RequestParam Double price) {
        return productService.findByPriceGreaterThan(price);
    }

    /**
     * Retrieves all products with price less than the specified value.
     * 
     * @param price The maximum price threshold (request parameter)
     * @return List of products with price less than the specified value
     */
    @GetMapping("/price/less")
    public List<Product> getByPriceLess(@RequestParam Double price) {
        return productService.findByPriceLessThan(price);
    }

    /**
     * Retrieves all products with price between the specified range (inclusive).
     * 
     * @param min The minimum price (inclusive) (request parameter)
     * @param max The maximum price (inclusive) (request parameter)
     * @return List of products within the specified price range
     */
    @GetMapping("/price/between")
    public List<Product> getByPriceBetween(
            @RequestParam Double min,
            @RequestParam Double max) {
        return productService.findByPriceBetween(min, max);
    }

    /**
     * Retrieves all products whose name contains the specified keyword.
     * 
     * @param keyword The keyword to search for in product names (request parameter)
     * @return List of products whose names contain the keyword
     */
    @GetMapping("/search/contains")
    public List<Product> getByNameContaining(@RequestParam String keyword) {
        return productService.findByNameContaining(keyword);
    }

    /**
     * Retrieves all products whose name starts with the specified prefix.
     * 
     * @param prefix The prefix to search for (request parameter)
     * @return List of products whose names start with the prefix
     */
    @GetMapping("/search/starts")
    public List<Product> getByNameStartingWith(@RequestParam String prefix) {
        return productService.findByNameStartingWith(prefix);
    }

    /**
     * Retrieves all products whose name ends with the specified suffix.
     * 
     * @param suffix The suffix to search for (request parameter)
     * @return List of products whose names end with the suffix
     */
    @GetMapping("/search/ends")
    public List<Product> getByNameEndingWith(@RequestParam String suffix) {
        return productService.findByNameEndingWith(suffix);
    }

    /**
     * Retrieves all products whose name contains the specified keyword and price is greater than the specified value.
     * 
     * @param name The keyword to search for in product names (request parameter)
     * @param price The minimum price threshold (request parameter)
     * @return List of products matching both criteria
     */
    @GetMapping("/search/contains-price")
    public List<Product> getByNameContainingAndPriceGreaterThan(
            @RequestParam String name,
            @RequestParam Double price) {
        return productService.findByNameContainingAndPriceGreaterThan(name, price);
    }

    /**
     * Retrieves all products whose name is in the specified list and price is within the specified range.
     * Uses POST method to handle complex request body (list of names).
     * 
     * @param names List of product names to search for (request body)
     * @param min The minimum price (inclusive) (request parameter)
     * @param max The maximum price (inclusive) (request parameter)
     * @return List of products matching both criteria
     */
    @PostMapping("/search/names-in-price-range")
    public List<Product> getByNameInAndPriceBetween(
            @RequestBody List<String> names,
            @RequestParam Double min,
            @RequestParam Double max) {
        return productService.findByNameInAndPriceBetween(names, min, max);
    }

    /**
     * Retrieves all products with the specified name (case-insensitive search).
     * 
     * @param name The name to search for (case-insensitive) (request parameter)
     * @return List of products with the specified name (ignoring case)
     */
    @GetMapping("/search/ignore-case")
    public List<Product> getByNameIgnoreCase(@RequestParam String name) {
        return productService.findByNameIgnoreCase(name);
    }

    /**
     * Retrieves all products ordered by price in ascending order.
     * 
     * @return List of all products sorted by price (lowest to highest)
     */
    @GetMapping("/sort/asc")
    public List<Product> getAllByPriceAsc() {
        return productService.findAllByOrderByPriceAsc();
    }

    /**
     * Retrieves all products ordered by price in descending order.
     * 
     * @return List of all products sorted by price (highest to lowest)
     */
    @GetMapping("/sort/desc")
    public List<Product> getAllByPriceDesc() {
        return productService.findAllByOrderByPriceDesc();
    }

    /**
     * Retrieves all products whose name contains the specified keyword, ordered by price in ascending order.
     * 
     * @param keyword The keyword to search for in product names (request parameter)
     * @return List of matching products sorted by price (lowest to highest)
     */
    @GetMapping("/search/contains-sort-asc")
    public List<Product> getByNameContainingSortedByPriceAsc(@RequestParam String keyword) {
        return productService.findByNameContainingOrderByPriceAsc(keyword);
    }

    /**
     * Retrieves all products within a specific price range using custom JPQL query.
     * 
     * @param minPrice The minimum price (inclusive) (request parameter)
     * @param maxPrice The maximum price (inclusive) (request parameter)
     * @return List of products within the specified price range
     */
    @GetMapping("/custom/price-range")
    public List<Product> searchByPriceRange(
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice) {
        return productService.searchByPriceRange(minPrice, maxPrice);
    }
}
