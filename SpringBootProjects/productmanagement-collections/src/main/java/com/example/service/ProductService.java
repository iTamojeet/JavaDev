package com.example.service;

import com.example.entity.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    Product getProductById(int id);
    List<Product> getAllProducts();
    String deleteProduct(int id);

    // Custom search operations
    List<Product> searchByName(String name);
    List<Product> searchByCategory(String category);
    List<Product> searchByPriceRange(double min, double max);
}
