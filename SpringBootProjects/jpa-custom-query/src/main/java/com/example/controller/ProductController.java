package com.example.controller;

import com.example.entity.Product;
import com.example.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
@CrossOrigin(origins = "*") // Allow CORS for frontend integration
public class ProductController {

    /**
     * Service layer for product business logic operations.
     * Injected via constructor using Lombok's @AllArgsConstructor.
     */
    private final ProductService productService;

    /**
     * Retrieves all products from the system.
     * 
     * @return ResponseEntity containing list of all products
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAll();
        return ResponseEntity.ok(products);
    }

    /**
     * Retrieves a product by its exact name.
     * 
     * @param name The exact name of the product (path variable)
     * @return ResponseEntity containing the product or 404 if not found
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) {
        Product product = productService.getAProductByName(name);
        return ResponseEntity.ok(product);
    }

    /**
     * Retrieves a product by both name and price using request parameters.
     * 
     * @param name The exact name of the product (request parameter)
     * @param price The exact price of the product (request parameter)
     * @return ResponseEntity containing the product or 404 if not found
     */
    @GetMapping("/name-price")
    public ResponseEntity<Product> getProductByNameAndPrice(
            @RequestParam String name,
            @RequestParam Double price) {
        Product product = productService.findByNameAndPrice(name, price);
        return ResponseEntity.ok(product);
    }

    /**
     * Retrieves all products with a specific price.
     * 
     * @param price The price to search for (request parameter)
     * @return ResponseEntity containing list of products with the specified price
     */
    @GetMapping("/price")
    public ResponseEntity<List<Product>> getByPrice(@RequestParam Double price) {
        List<Product> products = productService.findByPrice(price);
        return ResponseEntity.ok(products);
    }

    /**
     * Retrieves all products with price greater than the specified value.
     * 
     * @param price The minimum price threshold (request parameter)
     * @return ResponseEntity containing list of products with price greater than the specified value
     */
    @GetMapping("/price/greater")
    public ResponseEntity<List<Product>> getByPriceGreater(@RequestParam Double price) {
        List<Product> products = productService.findByPriceGreaterThan(price);
        return ResponseEntity.ok(products);
    }

    /**
     * Retrieves all products with price less than the specified value.
     * 
     * @param price The maximum price threshold (request parameter)
     * @return ResponseEntity containing list of products with price less than the specified value
     */
    @GetMapping("/price/less")
    public ResponseEntity<List<Product>> getByPriceLess(@RequestParam Double price) {
        List<Product> products = productService.findByPriceLessThan(price);
        return ResponseEntity.ok(products);
    }

    /**
     * Retrieves all products with price between the specified range (inclusive).
     * 
     * @param min The minimum price (inclusive) (request parameter)
     * @param max The maximum price (inclusive) (request parameter)
     * @return ResponseEntity containing list of products within the specified price range
     */
    @GetMapping("/price/between")
    public ResponseEntity<List<Product>> getByPriceBetween(
            @RequestParam Double min,
            @RequestParam Double max) {
        List<Product> products = productService.findByPriceBetween(min, max);
        return ResponseEntity.ok(products);
    }

    /**
     * Retrieves all products whose name contains the specified keyword.
     * 
     * @param keyword The keyword to search for in product names (request parameter)
     * @return ResponseEntity containing list of products whose names contain the keyword
     */
    @GetMapping("/search/contains")
    public ResponseEntity<List<Product>> getByNameContaining(@RequestParam String keyword) {
        List<Product> products = productService.findByNameContaining(keyword);
        return ResponseEntity.ok(products);
    }

    /**
     * Retrieves all products whose name starts with the specified prefix.
     * 
     * @param prefix The prefix to search for (request parameter)
     * @return ResponseEntity containing list of products whose names start with the prefix
     */
    @GetMapping("/search/starts")
    public ResponseEntity<List<Product>> getByNameStartingWith(@RequestParam String prefix) {
        List<Product> products = productService.findByNameStartingWith(prefix);
        return ResponseEntity.ok(products);
    }

    /**
     * Retrieves all products whose name ends with the specified suffix.
     * 
     * @param suffix The suffix to search for (request parameter)
     * @return ResponseEntity containing list of products whose names end with the suffix
     */
    @GetMapping("/search/ends")
    public ResponseEntity<List<Product>> getByNameEndingWith(@RequestParam String suffix) {
        List<Product> products = productService.findByNameEndingWith(suffix);
        return ResponseEntity.ok(products);
    }

    /**
     * Retrieves all products whose name contains the specified keyword and price is greater than the specified value.
     * 
     * @param name The keyword to search for in product names (request parameter)
     * @param price The minimum price threshold (request parameter)
     * @return ResponseEntity containing list of products matching both criteria
     */
    @GetMapping("/search/contains-price")
    public ResponseEntity<List<Product>> getByNameContainingAndPriceGreaterThan(
            @RequestParam String name,
            @RequestParam Double price) {
        List<Product> products = productService.findByNameContainingAndPriceGreaterThan(name, price);
        return ResponseEntity.ok(products);
    }

    /**
     * Retrieves all products whose name is in the specified list and price is within the specified range.
     * Uses POST method to handle complex request body (list of names).
     * 
     * @param names List of product names to search for (request body)
     * @param min The minimum price (inclusive) (request parameter)
     * @param max The maximum price (inclusive) (request parameter)
     * @return ResponseEntity containing list of products matching both criteria
     */
    @PostMapping("/search/names-in-price-range")
    public ResponseEntity<List<Product>> getByNameInAndPriceBetween(
            @RequestBody List<String> names,
            @RequestParam Double min,
            @RequestParam Double max) {
        List<Product> products = productService.findByNameInAndPriceBetween(names, min, max);
        return ResponseEntity.ok(products);
    }

    /**
     * Retrieves all products with the specified name (case-insensitive search).
     * 
     * @param name The name to search for (case-insensitive) (request parameter)
     * @return ResponseEntity containing list of products with the specified name (ignoring case)
     */
    @GetMapping("/search/ignore-case")
    public ResponseEntity<List<Product>> getByNameIgnoreCase(@RequestParam String name) {
        List<Product> products = productService.findByNameIgnoreCase(name);
        return ResponseEntity.ok(products);
    }

    /**
     * Retrieves all products ordered by price in ascending order.
     * 
     * @return ResponseEntity containing list of all products sorted by price (lowest to highest)
     */
    @GetMapping("/sort/asc")
    public ResponseEntity<List<Product>> getAllByPriceAsc() {
        List<Product> products = productService.findAllByOrderByPriceAsc();
        return ResponseEntity.ok(products);
    }

    /**
     * Retrieves all products ordered by price in descending order.
     * 
     * @return ResponseEntity containing list of all products sorted by price (highest to lowest)
     */
    @GetMapping("/sort/desc")
    public ResponseEntity<List<Product>> getAllByPriceDesc() {
        List<Product> products = productService.findAllByOrderByPriceDesc();
        return ResponseEntity.ok(products);
    }

    /**
     * Retrieves all products whose name contains the specified keyword, ordered by price in ascending order.
     * 
     * @param keyword The keyword to search for in product names (request parameter)
     * @return ResponseEntity containing list of matching products sorted by price (lowest to highest)
     */
    @GetMapping("/search/contains-sort-asc")
    public ResponseEntity<List<Product>> getByNameContainingSortedByPriceAsc(@RequestParam String keyword) {
        List<Product> products = productService.findByNameContainingOrderByPriceAsc(keyword);
        return ResponseEntity.ok(products);
    }

    /**
     * Retrieves all products within a specific price range using custom JPQL query.
     * 
     * @param minPrice The minimum price (inclusive) (request parameter)
     * @param maxPrice The maximum price (inclusive) (request parameter)
     * @return ResponseEntity containing list of products within the specified price range
     */
    @GetMapping("/custom/price-range")
    public ResponseEntity<List<Product>> searchByPriceRange(
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice) {
        List<Product> products = productService.searchByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok(products);
    }
}
