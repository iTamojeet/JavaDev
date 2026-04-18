package com.example.controller;

import com.example.entity.Product;
import com.example.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product create(@RequestBody Product p){
        return productService.save(p);
    }

    @GetMapping
    public List<Product> getAll(){
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id){
        return productService.getById(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product p){
        return productService.updateProduct(id,p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        productService.delete(id);
    }

    @PutMapping("/update_procedure/{id}")
    public void update(@PathVariable Long id, @RequestParam Double price){
        productService.updatePriceUsingProcedure(id, price);
    }

    @GetMapping("/recommend")
    public String recommend(@RequestParam String query){
        return productService.getRecommendations(query);
    }
}
