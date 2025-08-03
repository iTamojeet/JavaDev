package com.example.repository;

import com.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository interface for Product entity providing data access operations.
 *
 * This repository extends JpaRepository to inherit basic CRUD operations and
 * demonstrates various Spring Data JPA query methods including:
 * - Method name-based queries (Spring Data JPA naming conventions)
 * - Custom JPQL queries using @Query annotation
 * - Different search patterns (exact match, contains, starts/ends with)
 * - Price range queries and comparisons
 * - Sorting operations
 * - Case-insensitive searches
 * 
 * @author Tamojeet
 * @version 1.0
 * @since 2024-12-19
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

    /**
     * Find a product by its exact name.
     * 
     * @param name The exact name of the product to find
     * @return Product with the specified name, or null if not found
     */
    Product findByName(String name);
    
    /**
     * Find a product by both name and price.
     * 
     * @param name The exact name of the product
     * @param price The exact price of the product
     * @return Product matching both name and price, or null if not found
     */
    Product findByNameAndPrice(String name, Double price);
    
    /**
     * Find all products with a specific price.
     * 
     * @param price The price to search for
     * @return List of products with the specified price
     */
    List<Product> findByPrice(Double price);

    /**
     * Find all products with price greater than the specified value.
     * 
     * @param price The minimum price threshold
     * @return List of products with price greater than the specified value
     */
    List<Product> findByPriceGreaterThan(Double price);
    
    /**
     * Find all products with price less than the specified value.
     * 
     * @param price The maximum price threshold
     * @return List of products with price less than the specified value
     */
    List<Product> findByPriceLessThan(Double price);
    
    /**
     * Find all products with price between the specified range (inclusive).
     * 
     * @param min The minimum price (inclusive)
     * @param max The maximum price (inclusive)
     * @return List of products within the specified price range
     */
    List<Product> findByPriceBetween(Double min, Double max);
    
    /**
     * Find all products whose name contains the specified keyword.
     * Equivalent to SQL: WHERE name LIKE '%keyword%'
     * 
     * @param keyword The keyword to search for in product names
     * @return List of products whose names contain the keyword
     */
    List<Product> findByNameContaining(String keyword);         // LIKE %keyword%
    
    /**
     * Find all products whose name starts with the specified prefix.
     * Equivalent to SQL: WHERE name LIKE 'prefix%'
     * 
     * @param prefix The prefix to search for
     * @return List of products whose names start with the prefix
     */
    List<Product> findByNameStartingWith(String prefix);
    
    /**
     * Find all products whose name ends with the specified suffix.
     * Equivalent to SQL: WHERE name LIKE '%suffix'
     * 
     * @param suffix The suffix to search for
     * @return List of products whose names end with the suffix
     */
    List<Product> findByNameEndingWith(String suffix);

    /**
     * Find all products whose name contains the specified keyword and price is greater than the specified value.
     * 
     * @param name The keyword to search for in product names
     * @param price The minimum price threshold
     * @return List of products matching both criteria
     */
    List<Product> findByNameContainingAndPriceGreaterThan(String name, Double price);
    
    /**
     * Find all products whose name is in the specified list and price is within the specified range.
     * 
     * @param names List of product names to search for
     * @param min The minimum price (inclusive)
     * @param max The maximum price (inclusive)
     * @return List of products matching both criteria
     */
    List<Product> findByNameInAndPriceBetween(List<String> names, Double min, Double max);
    
    /**
     * Find all products with the specified name (case-insensitive search).
     * 
     * @param name The name to search for (case-insensitive)
     * @return List of products with the specified name (ignoring case)
     */
    List<Product> findByNameIgnoreCase(String name);

    /**
     * Find all products ordered by price in ascending order.
     * 
     * @return List of all products sorted by price (lowest to highest)
     */
    List<Product> findAllByOrderByPriceAsc();
    
    /**
     * Find all products ordered by price in descending order.
     * 
     * @return List of all products sorted by price (highest to lowest)
     */
    List<Product> findAllByOrderByPriceDesc();
    
    /**
     * Find all products whose name contains the specified keyword, ordered by price in ascending order.
     * 
     * @param keyword The keyword to search for in product names
     * @return List of matching products sorted by price (lowest to highest)
     */
    List<Product> findByNameContainingOrderByPriceAsc(String keyword);

    /**
     * Custom JPQL query to find products within a specific price range.
     * This method demonstrates the use of @Query annotation with JPQL.
     * 
     * @param minPrice The minimum price (inclusive)
     * @param maxPrice The maximum price (inclusive)
     * @return List of products within the specified price range
     */
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<Product> searchByPriceRange(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);

}
