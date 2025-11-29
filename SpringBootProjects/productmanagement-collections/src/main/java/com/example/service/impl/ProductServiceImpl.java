package com.example.service.impl;

import com.example.entity.Product;
import com.example.exception.ProductNotFoundException;
import com.example.service.ProductService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init(){
        products.add(new Product(1, "Laptop", 55000, "Electronics"));
        products.add(new Product(2, "Mobile", 30000, "Electronics"));
        products.add(new Product(3, "Shirt", 1500, "Fashion"));
        products.add(new Product(4, "Tablet", 55000, "Fashion"));
        IO.println("----------ready to test all-------------");
    }

    @Override
    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product getProductById(int id) {
        return products
                .stream()
                .filter( p -> p.getId()==id)
                .findFirst()
                .orElseThrow(()->new ProductNotFoundException("Product not found!!!"));
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public String deleteProduct(int id) {
        products.remove(getProductById(id));
        return "Product deleted successfully";
    }

    @Override
    public List<Product> searchByName(String name) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());

    }

    @Override
    public List<Product> searchByCategory(String category) {
        return products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());

    }

    @Override
    public List<Product> searchByPriceRange(double min, double max) {
        return products.stream()
                .filter(p -> p.getPrice() >= min && p.getPrice() <= max)
                .collect(Collectors.toList());

    }
}
